class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        bt(n,result,board,0);
        return result;
    }

    public void bt(int n,List<List<String>> result,char[][] board,int i){

        if(i==n){
            result.add(new ArrayList<>(construct(board)));
            return;
        }

        for(int j=0;j<n;j++){
           
            if(validQueen(board,i,j)){
                 board[i][j]='Q';
              bt(n,result,board,i+1);
 board[i][j]='.';
            }
           
        }
    }

    public boolean validQueen(char[][] board, int row, int col){
          int bRow = board.length-1;
          int bCol= board[0].length-1;

         for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // 2. Check 45-degree diagonal (top-left)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

          for(int i=row-1,j=col+1;i>=0 && j<=bCol;i--,j++){
                    if(board[i][j]=='Q')
                    return false;
          }

          return true;
    }

    public List<String> construct(char[][] board){
        List<String> op = new ArrayList<>();
        for(int i=0;i<board.length;i++){
           op.add(new String(board[i]));
        }

        return op;
    }
}
