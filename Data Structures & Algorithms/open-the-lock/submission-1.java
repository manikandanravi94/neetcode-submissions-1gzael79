class Solution {
    public int openLock(String[] deadends, String target) {
        
      

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

          if(visited.contains("0000"))
        return -1;

        Queue<String> queue = new LinkedList<>();

        queue.add("0000");
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                String current =queue.poll();
                
                if(current.equals(target)){
                    return level;
                }

                for(String neigh: getNeighbors(current)){
                    if(!visited.contains(neigh)){
                        visited.add(neigh);
                        queue.add(neigh);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private List<String> getNeighbors(String s){
        List<String> op = new ArrayList<>();
        char[] ch = s.toCharArray();

        for(int i=0;i<ch.length;i++){
              char old = ch[i];
            ch[i]=old=='9'? '0': (char)(old+1);
            op.add(new String(ch));
            ch[i]=old=='0'?'9': (char)(old-1);
            op.add(new String(ch));

            ch[i]=old;
        }

        return op;
    }
}