package leetcode410;

public class FindMinSumOfMaxSumSubArrayFunction {
	// O(n^2 * m) dp solution which is not fast at all, there is a binary search way but hard to understand
	public int splitArray(int[] nums, int m) {
        int[][] dp = new int[m][nums.length];
        
        dp[0][0] = nums[0];
        
        // Get all the sum up til each current element
        for(int i = 1; i < nums.length; i++){
            dp[0][i] = dp[0][i - 1] + nums[i];
        }
        
        // If m is 1, then just return the total sum which is last element
        for(int i = 1; i < m; i++){
           for(int j = i; j < nums.length; j++){
               int min = Integer.MAX_VALUE;
               
               // Get all the subarray and get the minimum sum for the max sum subarray
               for(int k = 0; k < j; k++){
                   min = Math.min(min, Math.max(dp[i - 1][k], dp[0][j] - dp[0][k]));
               }
               
               dp[i][j] = min;
           } 
        }
        
        return dp[m - 1][nums.length - 1];
    }
}
