class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] scores = new int[n+1];
        
        for(int[] edges : trust){
            int u=edges[0];
            int v=edges[1];
            scores[u]=scores[u]-1;
            scores[v]=scores[v]+1;
        }
        int judge=-1;
        for(int i=1;i<=n;i++){
              if(scores[i]==n-1){
                judge=i;
              }
        }
return judge;


        // List<List<Integer>> graph= new ArrayList();

        // for(int i=0;i<=n;i++){
        //       graph.add(i,new ArrayList<>());
        // }
        // int judge=-1;
        // for(int[] edges:trust){
        //     int u=edges[0];
        //     int v=edges[1];
        //     graph.get(u).add(v);
        //     // graph.get(v).add(u);
        // }

        // for(int i=1;i<=n;i++){
        //     if(graph.get(i).size()==0){
        //         judge=i;
        //     }
        // }
        // return judge;
    }
}