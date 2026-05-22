class Solution {

    public String encode(List<String> strs) {
          StringBuilder op = new StringBuilder();
          for(String s:strs){
               op.append(s.length());
               op.append("#");
               op.append(s);
          }
          return op.toString();
    }

    public List<String> decode(String s) {
        List<String> op = new ArrayList<>();
        int i=0;
         while(i<s.length()){
            int delimiterPos = s.indexOf('#',i);

            int length = Integer.parseInt(s.substring(i,delimiterPos));

            op.add(s.substring(delimiterPos+1,delimiterPos+length+1));

            i=delimiterPos+length+1;
         }
           return op;
    }
}
