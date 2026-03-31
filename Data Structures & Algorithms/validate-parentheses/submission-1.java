class Solution {
  static  Map<Character,Character> bracesMap = new HashMap();

  static {
      bracesMap.put('}','{');
        bracesMap.put(']','[');
        bracesMap.put(')','(');
  }
    public boolean isValid(String s) {
      
    Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(bracesMap.containsKey(ch)){
                if(st.isEmpty() || bracesMap.get(ch)!=st.pop()){
                    return false;
                }
            }else{
                st.push(ch);
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}
