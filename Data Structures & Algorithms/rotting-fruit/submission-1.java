class Solution {
    public int orangesRotting(int[][] grid) {
        int total=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] remEle=queue.poll();
                makeOrangeRotten(remEle[0],remEle[1],grid,queue);
            }
            if(queue.size()>0){
                total=total+1;
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
     
     return total;
    }

    public void makeOrangeRotten(int i, int j,int[][] grid,Queue<int[]> queue){
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        for(int[] neighbors:directions){
            int row=i+neighbors[0];
            int col=j+neighbors[1];
            if(row<0||col<0||row>=grid.length||col>=grid[0].length){
                continue;
            }
            if(grid[row][col]==1){
                grid[i+neighbors[0]][j+neighbors[1]]=2;
                queue.add(new int[]{row,col});
            }
        }
    }
}
