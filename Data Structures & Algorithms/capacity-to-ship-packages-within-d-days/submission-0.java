class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int weight:weights){
            low=Math.max(low,weight);
            high=high+weight;
        }

        while(low<high){
            int mid=(low+high)/2;
            
            if(canShip(weights,days,mid)){
                high=mid;
            }else{
                low=mid+1;
            }

        }

        return low;
    }

   private boolean canShip(int[] weights, int allowedDays, int capacity) {
        int daysUsed = 1; // Start with the first day
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                // Ship is full! Start a new day
                daysUsed++;
                currentLoad = w; // This package starts the new day
            } else {
                currentLoad += w;
            }
        }
        
        return daysUsed <= allowedDays;
    }
}