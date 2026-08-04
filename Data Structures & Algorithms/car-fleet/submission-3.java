class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length==1)
            return 1;
        
        // have a combined array that has 
        // 0th index is position
        // 1th position is speed
        int[][] combine = new int[position.length][2];
        for(int i=0; i<position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        // next sort the combined array based on position in increasing order
        Arrays.sort(combine, java.util.Comparator.comparingInt(o->o[0]));
        Stack<int[]> st = new Stack<>();
        double currTime, prevTime;
        int[] top;
        for(int i=combine.length-1; i>=0; i--) {
            currTime =(double) (target-combine[i][0]) / combine[i][1];

            // if currTime is smaller than top of the stack, 
            // then the one in stack is slower and we can ignore current car, 
            // as it's same fleet as the one on top of stack
            if(!st.isEmpty()) {
                top = st.peek();
                prevTime =(double) (target - top[0])/ top[1];
                if(currTime<=prevTime) {
                    continue;
                }
            }
            st.push(combine[i]);
        }

        return st.size();
    }
}
