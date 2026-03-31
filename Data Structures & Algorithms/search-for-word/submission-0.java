class Solution {
    public boolean exist(char[][] board, String word) {

       for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]==word.charAt(0)){
                if(checkString(board,word, 0,i,j)){
                    return true;
                }
            }
        }
       }
       return false;
    }

    private boolean checkString(char[][] board,String word, int index,int i, int j){

        
        if(index==word.length()){
            return true;
        }

        if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(index)!=board[i][j] ){
            return false;
        }

        char temp=board[i][j];
            board[i][j]='#';

        boolean isAvailable= checkString(board,word,index+1,i+1,j) ||
        checkString(board,word,index+1,i-1,j) ||
        checkString(board,word,index+1,i,j+1) ||
        checkString(board,word,index+1,i,j-1); 
        
        board[i][j]=temp;
         
        return isAvailable;
    }
}
