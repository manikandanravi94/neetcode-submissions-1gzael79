class Solution {
    public int countComponents(int n, int[][] edges) {
          List<List<Integer>> graph = new LinkedList<>();

          for(int i=0;i<n;i++){
            graph.add(i,new ArrayList<>());
          }

          for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
          }

          boolean[] visited=new boolean[n];
          int noOfComponents=0;
          for(int k=0;k<n;k++){
            if(!visited[k]){
             noOfComponents=noOfComponents+1;
             dfs(graph,visited,k);
            }
          }
        return noOfComponents;
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int vtx){
        if(!visited[vtx]){
            visited[vtx]=true;
            for(Integer i:graph.get(vtx)){
                dfs(graph,visited,i);
            }
        }
    }
}
