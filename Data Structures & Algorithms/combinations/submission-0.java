class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        bt(n,k,result, new ArrayList<>(),1);
        return result;
    }

    public void bt(int n, int k, List<List<Integer>> result, List<Integer> lst,int start){
     
     if(lst.size()==k){
        result.add(new ArrayList(lst));
        return;
     }

     if(lst.size()>k){
        return;
     }

     for(int i=start;i<=n;i++){
        lst.add(i);
        bt(n,k,result,lst,i+1);
        lst.remove(lst.size()-1);
     }

    }
}