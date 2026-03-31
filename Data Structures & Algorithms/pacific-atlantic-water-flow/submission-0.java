class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int c=0;c<cols;c++){
          dfs(heights,0,c,pacific,heights[0][c]);
          dfs(heights,rows-1,c,atlantic,heights[rows-1][c]);
        }

        for(int r=0;r<rows;r++){
            dfs(heights,r,0,pacific,heights[r][0]);
            dfs(heights,r,cols-1,atlantic,heights[r][cols-1]);
        }
        List<List<Integer>> result = new ArrayList();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> lst = new ArrayList();
                    lst.add(i);
                    lst.add(j);
                   result.add(lst);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight){
        if(r<0 || c<0 || r>=heights.length || c>=heights[0].length || visited[r][c] || heights[r][c]<prevHeight){
            return;
        }
        visited[r][c]=true;
        dfs(heights,r+1,c,visited,heights[r][c]);
        dfs(heights,r-1,c,visited,heights[r][c]);
        dfs(heights,r,c+1,visited,heights[r][c]);
        dfs(heights,r,c-1,visited,heights[r][c]);
    }
}
