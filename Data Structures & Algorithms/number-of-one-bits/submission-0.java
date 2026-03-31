class Solution {
    public int hammingWeight(int n) {
        int op=0;
        for(int i=0;i<31;i++){
             if((n&1)==1){
                op=op+1;
             }
             n=n>>1;
        }
        return op;
    }
}
