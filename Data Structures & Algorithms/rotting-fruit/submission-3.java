class Solution {
    public int orangesRotting(int[][] grid) {


        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int mins=0;
        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
                int[] position = queue.poll();
                int r=position[0];
                int c=position[1];
                makeOrangeRotten(grid,r,c,queue);
            }
        if(!queue.isEmpty())
        mins=mins+1;
        }

         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return mins;
    }

    private void makeOrangeRotten(int[][] grid, int i, int j,Queue<int[]> queue){
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int[] dir:directions){
            int newR=i+dir[0];
            int newC=j+dir[1];

            if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]==1){
                      grid[newR][newC]=2;
                      queue.add(new int[]{newR,newC});
            }
        }
    }
}
