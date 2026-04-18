class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] chArr1 = new int[26];

        for(int i=0;i<s1.length();i++){
            int ch=s1.charAt(i)-'a';
            chArr1[ch]++;
        }
        int[] chArr2 = new int[26];
        int left=0;
        for(int i=0;i<s2.length();i++){
             int ch =s2.charAt(i)-'a';
             chArr2[ch]++;
             if(i<s1.length()-1){
                continue;
             }
             StringBuilder sb = new StringBuilder();
             StringBuilder sb1= new StringBuilder();
             for(int j=0;j<26;j++){
                sb.append(chArr1[j]);
                sb1.append(chArr2[j]);
             }
             if(sb.toString().equals(sb1.toString())){
                return true;
             }
             chArr2[s2.charAt(left)-'a']--;
             left++;
        }
        return false;
    }
}
