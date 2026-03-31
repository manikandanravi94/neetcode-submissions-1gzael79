class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low=1;
        int high=0;
        for(int p:piles){
            high=Math.max(p,high);
        }

        while(low<high){
            int mid=(low+high)/2;

            if(canFinish(piles,h,mid)){
                high=mid;
            }else{
                 low=mid+1;
            }
        }

        return low;
    }

    private boolean canFinish(int[] piles, int allowedSpeed, int speed){
        int totalSpeed=0;
        for(int p: piles){
            totalSpeed+=(p+speed-1)/speed;
        }
        return totalSpeed<=allowedSpeed;
    }
}
