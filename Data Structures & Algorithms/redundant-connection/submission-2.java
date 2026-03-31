class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int max=0;
         for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            max=Math.max(max,Math.max(u,v));
         }

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=max;i++){
            graph.add(i,new ArrayList<>());
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            boolean[] visited = new boolean[max + 1];
            
            if(hasPath(u,v,visited,graph)){
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
         }
        return new int[2];
    }

    private boolean hasPath(int curr,int target, boolean[] visited,List<List<Integer>> graph){
        if(curr==target){
            return true;
        }

        visited[curr]=true;

        for(Integer neighbor: graph.get(curr)){
               if(!visited[neighbor]){
                if(hasPath(neighbor,target,visited,graph)){
                return true;
                }
               }
        }

        return false;
    }
}
