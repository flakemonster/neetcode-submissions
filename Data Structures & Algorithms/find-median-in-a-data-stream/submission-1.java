class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int maxHeapSize;
    int minHeapSize;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //System.out.println("adding "+num);
        if(maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else if(num<=maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        //System.out.println("Before rebalance maxHeap size "+ maxHeap.size()+" minHeap size "+minHeap.size());
        if((maxHeap.size() - minHeap.size())>1) {
            // rebalance as maxHeap is much larger
            //System.out.println("rebalance as maxHeap is much larger");
            while(maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        } else if ((minHeap.size() - maxHeap.size())>1) {
            // rebalance as minHeap is much larger
            //System.out.println("rebalance as minHeap is much larger");
            while(minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        }

    }
    
    public double findMedian() {
        //System.out.println("maxHeap size "+ maxHeap.size()+" minHeap size "+minHeap.size());
        double median = 0;
        if((maxHeap.size()+minHeap.size())%2 == 0) {
            median = (double)(maxHeap.peek() + minHeap.peek())/2;
            //System.out.println("median even "+median); 
            return median;
        }
        if(maxHeap.size() > minHeap.size())
            median = maxHeap.peek();
        else 
            median = minHeap.peek();
        //System.out.println("median odd "+median);
        return median;
    }
}
