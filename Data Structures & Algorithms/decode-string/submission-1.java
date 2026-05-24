class Solution {
    public String decodeString(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        for(char ch:s.toCharArray()){
            if(ch==']'){
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peekLast()!='['){
                    sb.append(st.pollLast());
                }
                st.pollLast();
                StringBuilder integerS = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peekLast())){
                   integerS.append(st.pollLast());
                }
                Integer count = Integer.parseInt(integerS.reverse().toString());
                String op = sb.reverse().toString();
                for(int i=0;i<count;i++){
                    for(char c:op.toCharArray()){
                        st.addLast(c);
                    }
                }
            }else{
                st.addLast(ch);
            }

        }
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.pollFirst());
        }
        return result.toString();
    }
}