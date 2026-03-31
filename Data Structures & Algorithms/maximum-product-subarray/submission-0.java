class Solution {
    public int maxProduct(int[] nums) {

        int res=nums[0];
        int curMax=nums[0];
        int curMin=nums[0];

        for(int i=1;i<nums.length;i++){
            int n=nums[i];
            if(n<0){
                int temp=curMin;
                curMin=curMax;
                curMax=temp;
            }
           
           curMax=Math.max(n,n*curMax);
           curMin=Math.min(n,n*curMin);

           res=Math.max(res,curMax);

        }
        return res;
    }
}
