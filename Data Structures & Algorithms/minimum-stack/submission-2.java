class MinStack {
    // normal stack operations for push, pop, top
    Stack<Integer> st;

    // extra stack for just getMin, always uses the min to be at the top at any given pt
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        
        if(minSt.isEmpty())
            minSt.push(val);
        else {
            if(val>minSt.peek()) {
                minSt.push(minSt.peek());
            } else {
                minSt.push(val);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty())
            return;
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        return st.isEmpty()?null:st.peek();
    }
    
    public int getMin() {
        return minSt.isEmpty()?null:minSt.peek();
    }
}
