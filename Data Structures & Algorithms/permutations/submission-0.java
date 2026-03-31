class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited,false);
        bt(nums, result, new ArrayList<>(),0, visited);
        return result;
    }

    public void bt(int[] nums,List<List<Integer>> result, List<Integer> lst, int start, boolean[] visited){

         if(lst.size()==nums.length){
            result.add(new ArrayList(lst));
            return;
         }

         for(int i=0;i<nums.length;i++){
            if(!visited[i]){
            lst.add(nums[i]);
            visited[i]=true;
            bt(nums,result,lst,i, visited);
            lst.remove(lst.size()-1);
            visited[i]=false;
            }
         }
    }
}
