class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }

        return unique(m-1,n-1,dp);
    }

    private int unique(int m, int n,int[][] dp){
        if(m<0 ||n<0){
            return 0;
        }
        if(m==0||n==0){
            return 1;
        }

        if(dp[m][n]==-1){
              dp[m][n]=unique(m-1,n,dp)+unique(m,n-1,dp);
        }
        return dp[m][n];
    }
}
