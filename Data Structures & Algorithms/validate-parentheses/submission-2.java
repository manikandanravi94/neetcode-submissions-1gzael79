class Solution {

    static Map<Character, Character> map = new HashMap<>();

    static{
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(map.containsKey(ch)){
              if(st.isEmpty() || map.get(ch)!=st.pop()){
                return false;
              }
            }else{
                st.push(ch);
            }
        }

        if(!st.isEmpty())
        return false;

        return true;
    }
}
