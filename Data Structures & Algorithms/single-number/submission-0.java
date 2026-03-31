class Solution {
    public int singleNumber(int[] nums) {
        
        int op=nums[0];
        for(int i=1;i<nums.length;i++){
            op=op^nums[i];
        }
        return op;
    }
}
