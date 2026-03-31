class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        bt(nums,result, new ArrayList<Integer>(),0);
        return result;
    }

    public void bt(int[] nums,List<List<Integer>> result, List<Integer> lst, int start){
           
           if(start<=nums.length){
            result.add(new ArrayList(lst));
           }

           if(start==nums.length){
            return;
           }

           for(int i=start;i<nums.length;i++){
            lst.add(nums[i]);
            bt(nums,result,lst,i+1);
            lst.remove(lst.size()-1);
           }
    }
}
