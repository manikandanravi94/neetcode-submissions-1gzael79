class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLength=0;
        int index=0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            while(set.contains(ch)){
                set.remove(s.charAt(index));
                index=index+1;
            }

            set.add(ch);
            maxLength=Math.max(maxLength,set.size());

        }

        return maxLength;
    }
}
