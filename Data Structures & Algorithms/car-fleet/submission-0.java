class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
      int n = position.length;
        if (n == 0) return 0;

        // Combine position and speed into a 2D array and sort by position (descending)
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i]; // Time to reach target
        }

        // Sort by starting position: Car closest to target comes first
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double currentMaxTime = 0;

        for (int i = 0; i < n; i++) {
            // If this car takes more time than the fleet in front of it, 
            // it cannot catch up. It starts a NEW fleet.
            if (cars[i][1] > currentMaxTime) {
                fleets++;
                currentMaxTime = cars[i][1];
            }
        }

        return fleets;
    }
}
