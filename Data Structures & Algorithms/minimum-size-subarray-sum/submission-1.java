class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minWindow=Integer.MAX_VALUE;
        int total=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            total=total+nums[right];
            while(total>=target){
                minWindow=Math.min(minWindow,right-left+1);
                total=total-nums[left];
                left++;
            }

        }
         return (minWindow==Integer.MAX_VALUE)?0:minWindow;

    }
}