class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(i, new ArrayList<>());
        }
        int[] dep = new int[numCourses];
        for(int[] edge:prerequisites){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            dep[v]=dep[v]+1;
        }

        for(int i=0;i<dep.length;i++){
            if(dep[i]==0){
                bfs(graph,dep,i);
            }
        }

        for(int i=0;i<dep.length;i++){
            if(dep[i]>0){
                return false;
            }
        }

        return true;
    }

    public void bfs(List<List<Integer>> graph, int[] dep, int vertex){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);

        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
                int remEle=queue.poll();
                List<Integer> resolveDeps = graph.get(remEle);
                for(int ver: resolveDeps){
                    dep[ver]=dep[ver]-1;
                    if(dep[ver]==0){
                        queue.add(ver);
                    }
                }
            }
        }
    }
}
