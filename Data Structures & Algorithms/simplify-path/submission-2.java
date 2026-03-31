class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("");
        Deque<String> deque = new LinkedList<>();

        for(String s:path.split("/")){
            if(s.isEmpty()|| s.length()==0){
                continue;
            }
            if(s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(!deque.isEmpty())
                deque.pollLast();
                continue;
            }
            deque.addLast(s);
        }
        while(!deque.isEmpty()){
           sb.append("/").append(deque.pollFirst());
        }
        return sb.length()==0?"/":sb.toString();
    }
}