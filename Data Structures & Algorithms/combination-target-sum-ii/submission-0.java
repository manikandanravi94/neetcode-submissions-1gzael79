class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        bt(candidates, target, result, new ArrayList<>(),0,0);
        return result;
    }

    public void bt(int[] nums, int target, List<List<Integer>> result, List<Integer> lst, int start, int total){
        if( total>target){
            return;
        }
        if(total==target){
            result.add(new ArrayList(lst));
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            lst.add(nums[i]);
            bt(nums,target,result,lst,i+1,total+nums[i]);
            lst.remove(lst.size()-1);
        }
    }
}
