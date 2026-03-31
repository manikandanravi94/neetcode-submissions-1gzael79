class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dp(n,dp);
    }

    private int dp(int n,int[] dp){
        if(n<=1){
            return 1;
        }

        if(dp[n]==-1){
            dp[n]=dp(n-1,dp)+dp(n-2,dp);
        }
        return dp[n]; 
    }
}
