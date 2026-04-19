class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        bt(n,k,new ArrayList<>(), result,1,visited);
        return result;
    }

    public void bt(int n, int size, List<Integer> lst, List<List<Integer>> result,int start, boolean[] visited){
   

      if(lst.size()==size){
         result.add(new ArrayList<>(lst));
         return;
      }

      for(int i=start;i<=n;i++){
         if(!visited[i]){
            lst.add(i);
            bt(n,size,lst,result,i+1,visited);
            lst.remove(lst.size()-1);
            visited[i]=false;
         }
      }
    }
}