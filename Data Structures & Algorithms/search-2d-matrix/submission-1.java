class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int row=matrix.length;
         int col=matrix[0].length;

         int l=0;
         int h =(row*col)-1;

         while(l<=h){
            int mid= (l+h)/2;

            int midVal= matrix[mid/col][mid%col];

            if(midVal==target){
                return true;
            }else if(midVal<target){
                l=mid+1;
            }else{
                h=mid-1;
            }
         }        
        return false;
    }
}
