class Solution {
    public boolean isAnagram(String s, String t) {
         int[] charCount=new int[26];
         
          if(s.length()!=t.length()){
            return false;
          }
         for(int i=0;i<s.length();i++){
            charCount[s.charAt(i)-97]++;
            charCount[t.charAt(i)-97]--;
         }
         

         for(int i=0;i<26;i++){
            if(charCount[i]!=0){
return false;
            }
         }

         return true;
    }
}
