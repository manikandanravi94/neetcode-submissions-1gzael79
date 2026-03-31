class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }

        // 2. Precompute Reachability Matrix: isPre[i][j] means i is a prerequisite of j
        boolean[][] isPre = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            // Run BFS starting from each course i
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            
            boolean[] visited = new boolean[numCourses];
            visited[i] = true;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                
                for (int neighbor : graph.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        isPre[i][neighbor] = true; // Mark i as a prerequisite of neighbor
                        queue.add(neighbor);
                    }
                }
            }
        }

        // 3. Answer all queries in O(1) using the precomputed matrix
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPre[query[0]][query[1]]);
        }

        return result;
    }

   
}