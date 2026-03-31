class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n =grid[0].length;
        int[][] dp = new int[m][n];

        for(int[] rows: dp){
            Arrays.fill(rows,-1);
        } 

        return minSum(grid,m-1,n-1,dp);
    }

    private int minSum(int[][] grid, int m, int n, int[][] dp){
        if (m == 0 && n == 0) {
        return grid[0][0];
    }

    // 2. Boundary Check: Out of bounds is "Infinitely" expensive
    if (m < 0 || n < 0) {
        return Integer.MAX_VALUE; // Prevents the min() from picking this path
    }

        if(dp[m][n]!=-1){
            return dp[m][n];
        }

        dp[m][n]=grid[m][n]+Math.min(minSum(grid,m-1,n,dp),
        minSum(grid,m,n-1,dp));

        return dp[m][n];
    }
}