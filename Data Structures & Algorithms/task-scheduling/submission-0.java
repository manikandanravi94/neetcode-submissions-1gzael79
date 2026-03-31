class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        // Step 1: Count frequencies
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        // Step 2: Max Heap for most frequent tasks
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }

        // Step 3: Queue for tasks in cooldown: [remaining_count, available_at_time]
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int count = pq.poll() - 1;
                if (count > 0) {
                    queue.add(new int[]{count, time + n});
                }
            }

            // Check if any task is done with cooldown
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                pq.add(queue.poll()[0]);
            }
        }

        return time;
    }
}
