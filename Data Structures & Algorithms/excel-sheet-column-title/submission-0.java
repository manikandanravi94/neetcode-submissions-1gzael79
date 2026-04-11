class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            // Step 1: Adjust to 0-indexed
            columnNumber--; 
            
            // Step 2: Get the character (0 -> 'A', 25 -> 'Z')
            char c = (char) ('A' + (columnNumber % 26));
            sb.append(c);
            
            // Step 3: Move to the next position
            columnNumber /= 26;
        }
        
        // Step 4: Reverse because we built it from right to left
        return sb.reverse().toString();
    }
}