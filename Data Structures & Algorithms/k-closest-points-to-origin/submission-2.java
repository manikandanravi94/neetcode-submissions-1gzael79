class Solution {
    public int[][] kClosest(int[][] points, int k) {
            int[][] op = new int[k][2];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for(int[] point: points){
            queue.add(new Point(point[0],point[1]));
        }
        int n=0;
        while(!queue.isEmpty()&&n<k){
            Point point =queue.poll();
            op[n][0]= point.x;
            op[n][1]=point.y;
            n++;
        }
        return op;
    }

      class Point implements Comparable{

        int x;

        int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Object o) {
          Point other = (Point) o;
    // Calculate squared distance: x^2 + y^2
    long thisDist = (long)this.x * this.x + (long)this.y * this.y;
    long otherDist = (long)other.x * other.x + (long)other.y * other.y;
    
    // Standard comparison: returns -1 if this is closer, 1 if further
    return Long.compare(thisDist, otherDist);
        }
    }
}
