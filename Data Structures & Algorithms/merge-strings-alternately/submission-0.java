class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        // Loop as long as there is at least one character left in either string
        while (i < word1.length() || i < word2.length()) {
            
            // If word1 still has characters, add the current one
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            
            // If word2 still has characters, add the current one
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            
            i++;
        }
        
        return result.toString();
    }
}