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
        if(maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else if(num<=maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if((maxHeap.size() - minHeap.size())>1) {
            while(maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        } else if ((minHeap.size() - maxHeap.size())>1) {
            while(minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        }

    }
    
    public double findMedian() {
        double median = 0;
        if((maxHeap.size()+minHeap.size())%2 == 0) {
            median = (double)(maxHeap.peek() + minHeap.peek())/2;
            return median;
        }
        if(maxHeap.size() > minHeap.size())
            median = maxHeap.peek();
        else 
            median = minHeap.peek();
        return median;
    }
}
