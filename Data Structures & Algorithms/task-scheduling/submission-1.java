class Solution {
    public int leastInterval(char[] tasks, int n) {
     if(n==0)return tasks.length;

     int[] frq = new int[26];

     for(char f:tasks){
        frq[f-'A']++;
     }

     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

     for(int i:frq){
        if(i>0)
        pq.add(i);
     }

     int time=0;
     Queue<int[]> q = new LinkedList<>();

     while( !pq.isEmpty() || !q.isEmpty()){
       time++;

       if(!pq.isEmpty()){
        int count = pq.poll()-1;
        if(count>0){
            q.add(new int[]{count,time+n});
        }
       }
       
       if(!q.isEmpty() && q.peek()[1]==time){
        pq.add(q.poll()[0]);
       }

     }

    return time;
    }
}
