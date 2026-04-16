class MyHashSet {

 private final int CAPACITY = 769; 
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getHash(int key) {
        return key % CAPACITY;
    }

    public void add(int key) {
        int index = getHash(key);
        // Avoid duplicates (since it's a Set)
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getHash(key);
        // Use Integer.valueOf to ensure we remove by object value, not index
        buckets[index].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = getHash(key);
        return buckets[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */