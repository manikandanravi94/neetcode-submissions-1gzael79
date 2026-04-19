class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        bt(nums,target,0,new ArrayList<>(),result,0);
        return result;
    }

    public void bt(int[] nums,int target, int sum, List<Integer> lst, List<List<Integer>> result,int start){
         
         if(sum>target){
            return;
         }

        if(sum==target){
            result.add(new ArrayList<>(lst));
            return;
        }

        int total=sum;
        
        for(int i=start;i<nums.length;i++){
            total=total+nums[i];
            lst.add(nums[i]);
            bt(nums,target,total,lst,result,i);
            lst.remove(lst.size()-1);
            total=total-nums[i];
        }
    }
}
