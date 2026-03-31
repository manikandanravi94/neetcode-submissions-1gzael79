class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack();
        int total=0;
        for(String s:operations){
            switch(s){
                case "+":
                int b=st.pop();
                int a=st.isEmpty()?0:st.pop();
                st.push(a);
                st.push(b);
                st.push(a+b);
                break;
                case "C":
                st.pop();
                break;
                case "D":
                st.push(st.peek()*2);
                break;
                default:
                a=Integer.parseInt(s);
                st.push(a);
                break;
            }
        }
        while(!st.isEmpty())
        {
            total=total+st.pop();
        }
        return total;
    }
}