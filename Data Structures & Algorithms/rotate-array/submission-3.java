class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        rotateI(nums,0,nums.length-1);
        rotateI(nums,0,k-1);
        rotateI(nums,k,nums.length-1);
    }

    public void rotateI(int[] nums,int start,int end){
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}