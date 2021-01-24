package leetcode410;

public class FindMinSumOfMaxSumSubArrayFunction {
	// O(n^2 * m) 
	// dp solution which is not fast at all
	public int splitArray(int[] nums, int m) {
        int[][] dp = new int[m][nums.length];
        
        dp[0][0] = nums[0];
        
        // Each element will be the sum of the left side and current element
        // Input: [7,2,5,10,8]
        // [7,2] = 9, [7,2,5] = 14 and so on ...
        // [7,9,14,24,32]
        for(int i = 1; i < nums.length; i++){
            dp[0][i] = dp[0][i - 1] + nums[i];
        }
        
        // If m is 1, then just return the total sum which is last element
        for(int i = 1; i < m; i++){
           for(int j = i; j < nums.length; j++){
               int min = Integer.MAX_VALUE;
               
               // j = 1
               // max of [7] [2] = 7
               
               // j = 2
               // max of [7] [2,5] = 7
               // max of [7,2] [5] = 9
               
               // j = 3
               // max of [7] [2,5,10] = 17
               // max of [7,2] [5,10] = 15
               // max of [7,2,5] [10] = 14
               
               // as k increase, that is the number of elements on the left
               for(int k = 0; k < j; k++){
                   min = Math.min(min, Math.max(dp[i - 1][k], dp[0][j] - dp[0][k]));
               }
               
               dp[i][j] = min;
           } 
        }
        
        return dp[m - 1][nums.length - 1];
    }
}
