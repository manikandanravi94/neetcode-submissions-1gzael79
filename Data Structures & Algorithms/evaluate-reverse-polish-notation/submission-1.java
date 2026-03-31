class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        Set<String> operators=new HashSet();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for(String s:tokens){
            if(operators.contains(s)){
                int b=Integer.parseInt(st.pop());
                int a=Integer.parseInt(st.pop());
                int op=0;
                switch(s){
                    case "+":
                    op=a+b;
                    break;
                    case "-":
                    op=a-b;
                    break;
                    case "*":
                    op=a*b;
                    break;
                    case "/":
                    op=a/b;
                    break;

                }
                st.push(String.valueOf(op));
                continue;
            }
          st.push(s);
        }
        return Integer.parseInt(st.pop());
    }
}
