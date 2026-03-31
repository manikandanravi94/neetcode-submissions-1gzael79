class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
       
        return Math.min(minCost(cost,cost.length-1,dp),minCost(cost,cost.length-2,dp));
    }

    private int minCost(int[] cost,int n, int[] dp){
        if(n<0){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n]=cost[n]+Math.min(minCost(cost,n-2,dp),minCost(cost,n-1,dp));
       

        return dp[n];
    }
}
