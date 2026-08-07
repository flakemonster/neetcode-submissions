class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0]*a[0]+a[1]*a[1], b[0]*b[0]+b[1]*b[1]));
        int[][] res = new int[k][2];

        for(int i=0; i<points.length; i++)
            minHeap.add(points[i]);

        int i = 0;
        while(i<k) {
            res[i] = minHeap.poll();
            i++;
        }
        return res;
    }
}
