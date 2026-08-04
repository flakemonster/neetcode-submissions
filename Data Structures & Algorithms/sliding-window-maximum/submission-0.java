class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // this dequeue stores indices and not values
        Deque<Integer> dq = new ArrayDeque<>();  
        int[] res = new int[n-k+1];

        // check the first k elements
        for(int i=0; i<k; i++) {
            // remove smalled elements from back
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) {
                dq.pollLast();
            }
            // add current element to back of the dq
            dq.offerLast(i);
        }

        // front of the dq is the max for the first k integers
        res[0]=nums[dq.peekFirst()];

        // process remaining elements
        for(int i=k; i<n; i++) {
            // remove the element that has slid out of window
            if(dq.peekFirst()<=i-k) {
                dq.pollFirst();
            }

            // remove all elements smaller than incoming element
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) {
                dq.pollLast();
            }

            // add current element's index
            dq.offerLast(i);

            // add to result the max which is the front of the dq always
            res[i-k+1]=nums[dq.peekFirst()];
        }
        return res;
    }
}
