class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i: stones) {
            pq.add(i);
        }

        int x, y;
        while(pq.size()>1) {
            x = pq.poll();
            y = pq.poll();
            pq.add(Math.abs(x-y));
        }
        return pq.poll();
    }
}
