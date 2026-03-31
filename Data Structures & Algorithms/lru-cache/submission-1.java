class LRUCache {

    Map<Integer, Node> map;

    Node head =null;
    Node tail = null;
    int size=0;



    public LRUCache(int capacity) {
        this.head = new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=tail;
        this.tail.prev=head;
        this.map = new HashMap();
        this.size=capacity;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            Node t = map.get(key);
            delete(t);
            insertBack(t.key,t.val);
            return t.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
           delete(map.get(key));
           insertBack(key,value);
        }else{
            if(map.size()==size){
               Node t =this.head.next;
               delete(t);
            }
             insertBack(key,value);            
        }
    }

    public void delete(Node t){
        Node t1 = t.next;
        Node t2=t.prev;
        t2.next=t1;
        t1.prev=t2;
      
        map.remove(t.key);
    }

    public void insertBack(int key, int value){
       Node nn = new Node(value, key);
    
    // Always insert BEFORE the stationary tail sentinel
    Node lastRealNode = this.tail.prev;
    
    lastRealNode.next = nn;
    nn.prev = lastRealNode;
    
    nn.next = this.tail;
    this.tail.prev = nn;
    
    this.map.put(key, nn);
    }
}


class Node {
    int val;

    int key;

    Node prev;

    Node next;

    public Node(int x, int key){
        this.val=x;
        this.key=key;
        prev=null;
        next=null;
    }
}