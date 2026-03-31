class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num:nums){
            pq.add(num);
        }
        while(k>1 && !pq.isEmpty()){
            pq.poll();
            k--;
        }
        return pq.isEmpty()?0:pq.poll();
    }
}
