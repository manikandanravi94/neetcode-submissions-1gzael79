class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int stone:stones){
            pq.add(stone);
        }

        while(pq.size()>1 && !pq.isEmpty()){
          pq.add(Math.abs(pq.poll()-pq.poll()));
        }
        return pq.isEmpty()?0:pq.poll();
    }
}
