class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] op = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();

        for(int course=0;course<numCourses;course++){
            graph.add(course, new ArrayList());
        }
        int[] dep = new int[numCourses];
        for(int[] edges: prerequisites){
            int u =edges[0];
            int v=edges[1];
            graph.get(v).add(u);
            dep[u]++;
        }
        Queue<Integer> queue= new LinkedList<>();
        int processedCourse=0;
        for(int i=0;i<dep.length;i++){
            if(dep[i]==0){
                queue.add(i);
                op[processedCourse++]=i;
            }
        }

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int remEle=queue.poll();
                for(int ele:graph.get(remEle)){
                    dep[ele]--;
                    if(dep[ele]==0){
                        queue.add(ele);
                        op[processedCourse++]=ele;
                    }
                }
            }
        }

        return processedCourse==numCourses?op: new int[]{};
    }
}
