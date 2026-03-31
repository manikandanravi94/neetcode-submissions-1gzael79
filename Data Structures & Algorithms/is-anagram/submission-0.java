class Solution {
    public boolean isAnagram(String s, String t) {
         int[] charCount=new int[26];
         int[] charCount2=new int[26];
          if(s.length()!=t.length()){
            return false;
          }
         for(int i=0;i<s.length();i++){
            charCount[s.charAt(i)-97]++;
         }
         for(int j=0;j<t.length();j++){
            charCount2[t.charAt(j)-97]++;
         }

         for(int i=0;i<26;i++){
            if(charCount[i]!=charCount2[i]){
return false;
            }
         }

         return true;
    }
}
