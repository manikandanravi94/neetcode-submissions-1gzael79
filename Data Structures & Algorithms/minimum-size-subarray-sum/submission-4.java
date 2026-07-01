class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int minWindow = Integer.MAX_VALUE;

       int left=0;
       int sum=0;

       for(int right=0;right<nums.length;right++){
         sum=sum+nums[right];
        while(sum>=target){
           minWindow=Math.min(minWindow,right-left+1);
           sum=sum-nums[left++];
        }
         
       }

       return minWindow==Integer.MAX_VALUE?0:minWindow;

    }
}