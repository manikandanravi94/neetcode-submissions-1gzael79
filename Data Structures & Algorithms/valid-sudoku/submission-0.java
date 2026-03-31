class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rowMap = new HashMap();
        Map<Integer,Set<Character>> colMap = new HashMap();
        Map<Integer,Set<Character>> squareMap = new HashMap();
        for(int c=0;c<board.length;c++){
            rowMap.put(c,new HashSet());
            colMap.put(c,new HashSet());
            squareMap.put(c,new HashSet());
        }
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(rowMap.get(i).contains(board[i][j])){
                 return false;
                }else{
                  rowMap.get(i).add(board[i][j]);
                }
                if(colMap.get(j).contains(board[i][j])){
                    return false;
                }else{
                    colMap.get(j).add(board[i][j]);
                }
                int boxIndex= (i/3)*3+(j/3);
                if(squareMap.get(boxIndex).contains(board[i][j])){
                    return false;
                }else{
                    squareMap.get(boxIndex).add(board[i][j]);
                }
            }
        }
        return true;
    }
}
