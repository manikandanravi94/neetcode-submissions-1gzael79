class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
   Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                   queue.add(new int[]{i,j});
                }
            }
        }
    
        while(!queue.isEmpty()){
         int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
          int[] remEle=queue.poll();
          int r=remEle[0];
          int c=remEle[1];
         for(int[] ne:directions){
            int nexR = r+ne[0];
            int nexC=c+ne[1];
            if(nexR>=0 && nexR<grid.length && nexC>=0 && nexC<grid[0].length){
                if(grid[nexR][nexC]==Integer.MAX_VALUE){
                    grid[nexR][nexC]=grid[r][c]+1;
                    queue.add(new int[]{nexR,nexC});
                }
            }
           
         }
        }
    }

}
