package Main;

import java.io.*;
import java.util.*;

// You are given a array of integers, you have to find how many AP are present in the array
// minimum number of elements should be three  to be considered as a AP. And the AP should
// be a subsequence of the array.
//
// Sample TC : -
//
// Input : [2, 4, 6, 8, 10, 12] Output : 7

public class ArithmeticSlicesLeetcode {
	public static void main (String[] args) throws IOException {
		int[] arr = { 2, 4, 6, 8, 10, 12 };
		solution(arr);
	}
	
	/**
	 * <h1>Solution</h1>
	 * 
	 * <p> Maintain a DP hashmap dp[i][j][k] where state is the number of APs j and k are part of. </p>
	 * 
	 * <p> Time : O(N^2) </p>
	 * <p> Space : O(N^2) </p>
	 * 
	 * @param arr
	 */
	public static void solution(int[] arr) {
		int n = arr.length;
		
		ArrayList<HashMap<Integer, Integer>> count = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			count.add( new HashMap<Integer, Integer>());
		}
		
		int ret = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] - arr[i] > Integer.MAX_VALUE || arr[j] - arr[i] < Integer.MIN_VALUE) {
					continue;
				}
				
				int diff = arr[j] - arr[i];
				if (count.get(j).containsKey(diff)) {
					count.get(i).replace(diff, count.get(i).get(diff) + count.get(j).get(diff));
					ret += count.get(i).get(diff);
				}
				
				count.get(i).replace(diff, count.get(i).get(diff) + 1);
			}
		}
		System.out.println(ret);
	}
}
