class Solution {
    public int maxProfit(int[] prices) {
        
        int buy=prices[0];
        int maxProfit=0;
         
        for(int i=1;i<prices.length;i++){
           
           while(buy>prices[i] && i<prices.length-1){
            buy=prices[i];
            i=i+1;
           }

           int currProfit=prices[i]-buy;
           maxProfit=Math.max(maxProfit,currProfit);

        }
        return maxProfit;
    }
}
