class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        bt(nums,result,new ArrayList<>(),0);
        return result;
    }

    public void bt(int[] nums, List<List<Integer>> result, List<Integer> lst,int start){
        
        result.add(new ArrayList(lst));

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
          lst.add(nums[i]);
          bt(nums,result,lst,i+1);
          lst.remove(lst.size()-1);
        }
    }
}
