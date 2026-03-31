class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return nonAdjSum(nums,nums.length-1,dp);
    }

    private int nonAdjSum(int[] nums, int i, int[] dp){
        if(i<0){
          return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        dp[i]=nums[i]+nonAdjSum(nums,i-2,dp);
        int solve=nonAdjSum(nums,i-1,dp);

        
        return Math.max(dp[i],solve);
    }
}
