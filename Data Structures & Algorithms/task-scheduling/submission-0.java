class Solution {
    public int leastInterval(char[] tasks, int n) {
        // frequency map for tasks
        int[] taskFreq = new int[26];

        for(char c: tasks) {
            taskFreq[c-'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int counter: taskFreq) {
            if(counter > 0)
                maxHeap.add(counter);
        }

        int time = 0;

        Queue<int[]> q = new LinkedList<>();
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                // check from queue
                // for time where the task is available next
                // index 2 of the queue item stored.
                time = q.peek()[1];
            } else {
                // in this case, maxHeap has values
                // check the most frequent element in heap
                // run it

                // reduce the count as it's been processed once now
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }
                if(!q.isEmpty() && q.peek()[1] == time) {
                    maxHeap.add(q.poll()[0]);
                }
            }
        
        return time;
    }
}

