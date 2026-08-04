class Solution {
    public int largestRectangleArea(int[] heights) {
        // calculate nse, pse
        // area = arr[i] * (nse index - pse index-1)
        int maxArea = 0;

        // stack stores index and not values
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<heights.length; i++) {
            int currHeight = heights[i];
            // first find the element you're going to compute nse, pse for
            while(!st.isEmpty() && heights[st.peek()]>currHeight) {
                // this stack top is the current element for which we can easily compute
                // nse
                int elementIndex = st.pop();
                int nseIndex = i;
                int pseIndex = st.isEmpty()?-1:st.peek();
                maxArea = Math.max(maxArea, (nseIndex-pseIndex-1)*heights[elementIndex]);
            }
            st.push(i);
        }

        // there could still be some elements for which we couldn't find nse

        while(!st.isEmpty()) {
            int elementIndex = st.pop();

            // nse for such element would be hypothetical max index i.e length itself
            int nseIndex = heights.length;

            // if stack has top then that's the pse
            int pseIndex = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(maxArea, (nseIndex-pseIndex-1)*heights[elementIndex]);
        }

        return maxArea;
    }
}