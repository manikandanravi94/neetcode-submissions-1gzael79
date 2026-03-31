class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<int[]> st= new Stack<>();
        int[] res = new int[t.length];
        for(int i=t.length-1;i>=0;i--){
           
           while(!st.isEmpty() && st.peek()[0]<=t[i]){
                st.pop();
           }
            int op=0;
            if(!st.isEmpty()){
                op=st.peek()[1]-i;
            }
           st.push(new int[]{t[i],i});
           res[i]=op;
        }
        return res;
    }
}
