class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        int[] op = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(i,new ArrayList());
        }
        int[] dep = new int[numCourses];
        for(int[] edges:prerequisites){
            int u=edges[0];
            int v=edges[1];
            graph.get(v).add(u);
            dep[u]++;
        }

        int processedCourse=0;
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(dep[i]==0){
             queue.add(i);
             op[processedCourse]=i;
             processedCourse++;
            }
           
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int remEle=queue.poll();
                for(int j:graph.get(remEle)){
                    dep[j]--;
                    if(dep[j]==0){
                        queue.add(j);
                        op[processedCourse]=j;
                        processedCourse++;
                    }
                }
            }
        }
        return processedCourse==numCourses?op:new int[0];
    }
}
