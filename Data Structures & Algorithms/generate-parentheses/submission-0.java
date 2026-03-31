class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        bt(n, result,new StringBuilder(), 0,0);
        return result;
    }

    public void bt(int n,List<String> result, StringBuilder sb, int openCount,int closeCount){
        if(sb.length()==n*2){
            result.add(sb.toString());
            return;
        }

        if(openCount<n){
          sb.append("(");
          bt(n,result,sb,openCount+1,closeCount);
          sb.deleteCharAt(sb.length()-1);
        }
         if(closeCount<openCount){
          sb.append(")");
          bt(n,result,sb,openCount,closeCount+1);
           sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
