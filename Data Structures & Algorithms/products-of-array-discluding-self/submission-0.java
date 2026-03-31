class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] op = new int[nums.length];
        op[0]=1;
        for(int i=1;i<nums.length;i++){
            op[i]=op[i-1]*nums[i-1];
        }
        
        int suffix=1;
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
           op[i]=op[i]*suffix;
           suffix=suffix*nums[i];
        }
        return op;
    }
}  
