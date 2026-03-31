class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(i,new ArrayList());
        }
        int[] dep=new int[numCourses];
        for(int[] edges:prerequisites){
            int u=edges[0];
            int v=edges[1];
            graph.get(u).add(v);
            dep[v]=dep[v]+1;
        }

        for(int i=0;i<numCourses;i++){
            if(dep[i]==0){
             bfs(graph,dep,i);
            }
        }

        boolean canFinish=true;
        for(int i=0;i<numCourses;i++){
            if(dep[i]>0){
                canFinish=false;
            }
        }
return canFinish;
    }

    public void bfs(List<List<Integer>> graph, int[] dep, int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        
        while(!queue.isEmpty()){
            int size=queue.size();
        for(int i=0;i<size;i++){
            int remEle=queue.poll();
            for(int j:graph.get(remEle)){
                dep[j]=dep[j]-1;
                if(dep[j]==0){
                    queue.add(j);
                }
            }
        }
        }
    }
}
