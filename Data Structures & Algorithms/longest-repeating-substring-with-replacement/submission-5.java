class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength=0;
         int[] chArray = new int[26];
         int maxFr=0;
         int left=0;
        for(int right=0;right<s.length();right++){
             int ch = s.charAt(right)-'A';
             chArray[ch]++;
             maxFr=Math.max(maxFr,chArray[ch]);
             while(right-left+1 - maxFr >k){
                chArray[s.charAt(left)-'A']--;
                left++;
             }
             maxLength=Math.max(maxLength,right-left+1);
        }

        return maxLength;
    }
}
