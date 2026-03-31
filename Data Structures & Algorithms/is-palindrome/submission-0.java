class Solution {
    public boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        s=s.toLowerCase();
        while(start<end){
            char a=s.charAt(start);
            char b=s.charAt(end);
            if(!Character.isLetterOrDigit(a)){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(b)){
                end--;
                continue;
            }
            if(a==b){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
