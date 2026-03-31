class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st= new LinkedList<>();

        for(int as:asteroids){
            boolean destroyed=false;
            while(!st.isEmpty() && as<0 && st.peekLast()>0){
               if(st.peekLast()<Math.abs(as)){
                st.removeLast();
                continue;
               }
               if(st.peekLast()==Math.abs(as)){
                st.removeLast();
                destroyed=true;
               }else{
                destroyed=true;
               }
             break;
            }
            if(!destroyed){
                st.addLast(as);
            }
         
        }
        int[] op = new int[st.size()];
        int i=0;
        while(!st.isEmpty())
        {
            op[i]=st.removeFirst();
            i++;
        }
        return op;
    }
}