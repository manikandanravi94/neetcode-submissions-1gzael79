class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        bt(nums,new ArrayList<>(),result,visited);
        return result;
    }

    public void bt(int[] nums,List<Integer> lst, List<List<Integer>> result,boolean[] visited){

       if(lst.size()==nums.length){
         result.add(new ArrayList<>(lst));
         return;
       }

       for(int i=0;i<nums.length;i++){
       
       if (visited[i]) continue;

            // FIX DUPLICATES: 
            // If current element is same as previous, AND previous wasn't used in this path,
            // it means we already explored this value at THIS level of the tree.
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            lst.add(nums[i]);
            visited[i]=true;
            bt(nums,lst,result,visited);
            lst.remove(lst.size()-1);
            visited[i]=false;
         
       }

    }
}