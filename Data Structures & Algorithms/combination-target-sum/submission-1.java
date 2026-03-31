class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        bt(nums,target,result, new ArrayList<>(),0,0);
        return result;
    }

    public void bt(int[] nums,int target,List<List<Integer>> result,List<Integer> lst,int start, int total){
        if(total>target || start>=nums.length){
            return;
        }

        if(target==total){
            result.add(new ArrayList(lst));
            return;
        }

        for(int i=start;i<nums.length;i++){
            total=total+nums[i];
            lst.add(nums[i]);
            bt(nums,target,result,lst,i,total);
            total=total-nums[i];
            lst.remove(lst.size()-1);
        }
    }
}
