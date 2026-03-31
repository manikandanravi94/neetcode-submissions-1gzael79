class Solution {
    public int maxArea(int[] heights) {
        
        int start=0;
        int end=heights.length-1;

        int maxArea=0;

        while(start<end){
          int curArea=Math.min(heights[start],heights[end])*(end-start);
          if(heights[start]<heights[end]){
start++;
          }
        else{
end--;
        }  
          maxArea=Math.max(maxArea,curArea);
        }

        return maxArea;
    }
}
