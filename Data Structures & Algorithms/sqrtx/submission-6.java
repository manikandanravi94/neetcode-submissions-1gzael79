class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int start=2;
        int end=x/2;

        while(start<=end){
            int mid=start+(end-start)/2;

            long num = (long) mid*mid;
            if(num==x){
                return mid;
            }else if(num<x){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end;
    }
}