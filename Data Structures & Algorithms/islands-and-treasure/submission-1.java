class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[][] directions = new int[][]{{0,1},{-1,0},{1,0},{0,-1}};
               int[] remEle= queue.poll();
            for(int[] ne: directions){
                int newR=remEle[0]+ne[0];
                int newC=remEle[1]+ne[1];
                if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length){
                    if(grid[newR][newC]==Integer.MAX_VALUE){
                        queue.add(new int[]{newR,newC});
                        grid[newR][newC]=grid[remEle[0]][remEle[1]]+1;
                    }
                }
            }
        }
        
    }
}
