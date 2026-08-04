class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // monotonically decreasing, stores indices, temp
        
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];
        
        // start from reverse
        for(int i=temperatures.length-1; i>=0; i--) {
            // pop the elements that are smaller than current element
            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]) {
                st.pop();
            }

            // if the stack still has elements, that means next warmer temperature is available
            if(!st.isEmpty()) {
                res[i] = st.peek()-i;
            }

            // push the index into stack
            st.push(i);
        }
        return res;
    }
}
