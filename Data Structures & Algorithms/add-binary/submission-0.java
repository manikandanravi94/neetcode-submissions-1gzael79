class Solution {
    public String addBinary(String a, String b) {
       StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        // One loop to rule them all
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry; // Start with the carry from the previous step
            
            if (i >= 0) sum += a.charAt(i--) - '0'; // Convert char to int ('1' -> 1)
            if (j >= 0) sum += b.charAt(j--) - '0';
            
            sb.append(sum % 2); // The binary digit (0 or 1)
            carry = sum / 2;    // The new carry (if sum is 2 or 3, carry is 1)
        }

        return sb.reverse().toString();
    }
}