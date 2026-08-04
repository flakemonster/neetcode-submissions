public class Node{
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
    Node head, tail;
    Map<Integer, Node> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        this.head=new Node(0, 0);
        this.tail=new Node(0, 0);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    
    // remove from DLL
    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // tail stores most recently used
    // have to update the tail when updating recently used
    private void insertAtTail(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.next = tail;
        node.prev = prev;
        tail.prev = node;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        remove(node); // remove it from it's place
        insertAtTail(node); // add it at tail where it's most recently used
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insertAtTail(node);

        if(cache.size()>capacity) {
            // evict the lru which is at head
            Node lru = cache.get(head.next.key);
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
