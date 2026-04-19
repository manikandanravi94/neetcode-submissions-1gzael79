class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        bt(nums,result,0, new ArrayList<>());
        return result;
     }

    public void bt(int[] nums, List<List<Integer>> result, int start,List<Integer> lst){
        
        result.add(new ArrayList<>(lst));

        for(int i=start;i<nums.length;i++){
            lst.add(nums[i]);
            bt(nums,result,i+1,lst);
            lst.remove(lst.size()-1);
        }


    }
}
