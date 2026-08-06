class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        while(i<stones.length) {
            pq.add(stones[i]);
            i++;
        }

        while(pq.size()>1) {
            int x = pq.poll();
            int y = pq.poll();
            pq.add(Math.abs(x-y));
        }
        return pq.poll();
    }
}
