class KthLargest {
    // min heap, where min element is always at root
    // implemented by priority queue
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        for(int i: nums) {
            pq.add(i);
        }
        this.k = k;
        minHeapify();
    }
    
    private void minHeapify() {
        while(pq.size()>k) {
            pq.poll();
        }
    }
    public int add(int val) {
        pq.add(val);
        minHeapify();
        return pq.peek();
    }
}
