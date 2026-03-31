class KthLargest {

    private PriorityQueue<Integer> queue;

    int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k;
        
        for (int num : nums) {
            add(num); // Reuse the add logic to keep it clean!
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        
        // If we have more than k elements, the smallest one 
        // cannot be the kth largest, so get rid of it.
        if (queue.size() > k) {
            queue.poll();
        }
        
        // The head of the Min-Heap is now the kth largest
        return queue.peek();
    }
}
