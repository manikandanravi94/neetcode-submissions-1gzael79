class Solution {
    public boolean isAlienSorted(String[] words, String order) {
       int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            boolean foundDifference = false;

            int minLen = Math.min(s1.length(), s2.length());
            for (int j = 0; j < minLen; j++) {
                char char1 = s1.charAt(j);
                char char2 = s2.charAt(j);

                if (char1 != char2) {
                    // If s1's char is greater, the whole list is invalid
                    if (map[char1 - 'a'] > map[char2 - 'a']) {
                        return false;
                    }
                    // If s1's char is smaller, this pair is valid. Move to next word!
                    foundDifference = true;
                    break; 
                }
            }

            // If we didn't find a difference and s1 is longer than s2 (e.g., "apple", "app")
            if (!foundDifference && s1.length() > s2.length()) {
                return false;
            }
        }
        return true;
    }
}