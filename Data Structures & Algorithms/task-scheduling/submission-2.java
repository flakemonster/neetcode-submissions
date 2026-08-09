class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // 1. build freq map
        for(char c: tasks) {
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }

        // 2. initialize max heap with all frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.addAll(freqMap.values());

        // 3. process the heap
        int time = 0;
        while(!maxHeap.isEmpty()) {
            // initialize a temp
            // list to take care of processing from heap every iteration
            List<Integer> tmp = new ArrayList<>();
            for(int i=0; i<n+1; i++) {
                // loop runs n+1 times as a char/freq can't repeat
                // in n+1 interval.
                if(!maxHeap.isEmpty()) {
                    tmp.add(maxHeap.poll());
                }
            }

            // now process the tmp list
            for(int freq: tmp) {
                // update the frequency, reduce by 1
                int newFreq = freq - 1;
                if(newFreq>0) {
                    // don't update heap with 0 values
                    maxHeap.add(newFreq);
                }
            }

            time += maxHeap.isEmpty()? tmp.size():(n+1);
        }

        return time;
    }
}
