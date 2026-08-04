class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<temperatures.length; i++) {
            m.put(temperatures[i], i);
            int curVal = temperatures[i];

            //pop elements from stack until they're smaller than current val
            // if you find element to pop, use that index to calculate res
            while(!st.isEmpty() && curVal>temperatures[st.peek()]) {
                // pop
                int idx = st.pop();
                res[idx] = i-idx;
            }
            // push index to stack
            st.push(i);
        }
        return res;
    }
}
