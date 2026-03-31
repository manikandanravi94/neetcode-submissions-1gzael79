class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> op =new ArrayList<>();
        if(strs.length==0||strs==null){
            return op;
        }
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            int[] count= new int[26];
             
             StringBuilder sb = new StringBuilder();
            for(char ch: str.toCharArray()){
                count[ch-'a']++;
            }

            for(int i=0;i<26;i++){ 
                 sb.append("#");
                 sb.append(count[i]);
            }
            map.compute(sb.toString(),(k,v)->{
                if(v==null)
                v=new ArrayList<>();
                v.add(str);
                return v;
            });
        }
        return new ArrayList(map.values());
    }
}
