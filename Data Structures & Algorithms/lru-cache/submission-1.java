class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key=key;
        this.val=val;
        next=null;
        prev=null;
    }
}
class LRUCache {
    // head and tail are dummy nodes
    Node head, tail;
    int capacity;

    // hashmap to track key and node
    HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    
    // remove node from DLL
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // head's next stores the most recently used
    // tail's prev stores the least recently used
    private void insertAtHead(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insertAtHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            cache.remove(key);
            remove(node);
        }

        Node nodeToInsert = new Node(key, value);
        insertAtHead(nodeToInsert);
        cache.put(key, nodeToInsert);
        
        if(cache.size()>capacity){
            // remove lru
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
