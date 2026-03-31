class Solution {

    static String[] charMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        List<String> lst = new ArrayList<>();
        bt(digits,lst,sb,0);
        return lst;
    }

    private void bt(String ip, List<String> lst,StringBuilder sb,int index){

          if(sb.length()==ip.length()){
            if(sb.length()>0)
            lst.add(sb.toString());
            return;
           }
         
           String s =charMap[ip.charAt(index)-'0'];
           for(int i=0;i<s.length();i++){
                sb.append(s.charAt(i));
                bt(ip,lst,sb,index+1);
                sb.deleteCharAt(sb.length()-1);
           }
    }
}
