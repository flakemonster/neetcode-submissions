class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        Stack<Integer> st = new Stack<>();

        int idx;
        for(int i=0; i<temperatures.length; i++) {

            //pop elements from stack until they're smaller than current val
            // if you find element to pop, use that index to calculate res
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]) {
                // pop
                idx = st.pop();
                res[idx] = i-idx;
            }
            // push index to stack
            st.push(i);
        }
        return res;
    }
}
