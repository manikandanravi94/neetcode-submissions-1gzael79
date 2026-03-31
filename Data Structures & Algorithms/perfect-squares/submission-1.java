class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dp(n,dp);
    }

    private int dp(int n, int[] dp){
             if(n<=0){
                return 0;
             }
             if(dp[n]!=-1){
                return dp[n];
             }

              int minSquare=n;           
            for(int i=1;i*i<=n;i++){
            int res=1+dp(n-i*i,dp);
            minSquare=Math.min(minSquare,res);
            }
            return dp[n]=minSquare;
    }
}