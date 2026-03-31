class Solution {
    public void solve(char[][] board) {
        int r=board.length;
        int c=board[0].length;
        for(int i=0;i<r;i++){
            markSafe(board,i,0);
            markSafe(board,i,c-1);
        }
        for(int j=0;j<c;j++){
            markSafe(board,0,j);
            markSafe(board,r-1,j);
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
                
            }
        }
    }

    public void markSafe(char[][] board, int r, int c){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!='O'){
            return;
        }
        board[r][c]='T';
        markSafe(board,r+1,c);
        markSafe(board,r-1,c);
        markSafe(board,r,c+1);
        markSafe(board,r,c-1);
    }
}
