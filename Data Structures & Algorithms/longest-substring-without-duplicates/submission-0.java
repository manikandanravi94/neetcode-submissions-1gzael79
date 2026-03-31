class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
         int maxCount=0;
         int index=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            while(set.contains(ch)) {
                set.remove(s.charAt(i-index));
                index=index-1;
            }
            set.add(ch);
            index=set.size();
             maxCount=Math.max(maxCount,set.size());
        }
        return maxCount;
    }
}
