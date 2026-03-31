class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length-1];
         Arrays.fill(dp,-1);
        int maxFirst=maxSum(nums,nums.length-2,0,dp);

        int[] dp1 = new int[nums.length+1];
Arrays.fill(dp1,-1);
        int maxSecond = maxSum(nums,nums.length-1,1,dp1);

        return Math.max(maxFirst,maxSecond);
        
    }

    public int maxSum(int[] nums, int i, int end, int[] dp){
        if(i<end){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int rob=nums[i]+maxSum(nums,i-2,end,dp);
        int rem=maxSum(nums,i-1,end,dp);

        return dp[i]=Math.max(rob,rem);
    }
}
