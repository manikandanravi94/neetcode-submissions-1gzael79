class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){

            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int start=i+1;
            int end=nums.length-1;
            int target=-nums[i];
            while(start<end){
               int sum=nums[start]+nums[end];
               if(sum==target){
                List<Integer> lst=new ArrayList();
                lst.add(nums[i]);
                lst.add(nums[start]);
                lst.add(nums[end]);
                result.add(lst);
                while(start<end && nums[start]==nums[start+1])start++;
                while(start<end && nums[end]==nums[end-1])end--;

                start++;
                end--;
               }else if(sum<target){
                start++;
               }else{
                end--;
               }
            }
        }
        return result;
    }
}
