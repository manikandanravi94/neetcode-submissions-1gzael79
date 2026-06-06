class LRUCache {

    private Map<Integer,Node> map;

    private Node head;

    private Node tail;

    private int capacity;

    public LRUCache(int capacity) {
        this.head = new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=this.tail;
        this.tail.prev=this.head;
        this.map=new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node =map.get(key);
            delete(node);
            insertBack(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
          if(map.containsKey(key)){
            delete(map.get(key));
        }
       
         if(map.size()==this.capacity){
            delete(this.head.next);
        }
      
        insertBack(new Node(key,value));
    }

    public void delete(Node node){
         Node deleteNode=node;

         deleteNode.prev.next=deleteNode.next;
         deleteNode.next.prev=deleteNode.prev;
         this.map.remove(node.key);
    }

    public void insertBack(Node node){
          Node lastRealNode = this.tail.prev;

          Node nn=node;

          lastRealNode.next=nn;
          nn.next=this.tail;
          nn.prev=lastRealNode;
          this.tail.prev=nn;
          this.map.put(nn.key,nn);
    }
}

class Node{

    private int key;

    private int val;

    private Node prev;

    private Node next;

    Node(int key,int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}
