package leetcode410;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] nums = {7,2,5,10,8};
		
		int m = 3;
		
		System.out.println("Input: " + Arrays.toString(nums) + " m: " + m);
		
		FindMinSumOfMaxSumSubArrayFunction solution = new FindMinSumOfMaxSumSubArrayFunction();
		
		System.out.println("Solution: " + solution.splitArray(nums, m));
	}
}
