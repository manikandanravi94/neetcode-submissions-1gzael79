class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return calculateAmt(nums,dp,nums.length-1);
    }

    private int calculateAmt(int[] nums, int[] dp, int i){
        if(i<0)
        return 0;

        if(dp[i]!=-1)
        return dp[i];

        dp[i]=nums[i]+calculateAmt(nums,dp,i-2);
        int adjSum = calculateAmt(nums,dp,i-1);

        return Math.max(dp[i],adjSum);
    }
}
