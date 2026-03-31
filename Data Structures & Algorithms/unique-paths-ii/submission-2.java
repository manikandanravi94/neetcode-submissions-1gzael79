class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1){
            return 0;
        }

        int[][] dp = new int[m][n];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return unique(obstacleGrid,m-1,n-1,dp);
    }

    public int unique(int[][] grid,int m,int n,int[][] dp){
        if(m<0||n<0||grid[m][n]==1){
            return 0;
        }

        if(m==0 && n==0){
            return 1;
        }

        if(dp[m][n]==-1){
            dp[m][n]=unique(grid,m-1,n,dp)+unique(grid,m,n-1,dp);
        }

        return dp[m][n];
    }
}