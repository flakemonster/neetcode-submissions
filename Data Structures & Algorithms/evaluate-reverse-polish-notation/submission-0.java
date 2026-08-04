class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        int val;
        int i=0;
        Integer res = 0;
        while(i<tokens.length) {
            if(!"+-*/".contains(tokens[i])) {
                // push the value into stack
                st.push(Integer.parseInt(tokens[i]));
            } else {
                // it's an operand, don't push, instead pop
                // top 2 elements and compute the result using operand
                Integer operand2 = st.pop();
                Integer operand1 = st.pop();
                switch(tokens[i]) {
                    case "+":
                        res = operand1+operand2;
                        break;
                    case "-":
                        res = operand1-operand2;
                        break;
                    case "*":
                        res = operand1*operand2;
                        break;
                    case "/":
                        res = operand1/operand2;
                }
                st.push(res);
            }
            i++;
        }
        return (int)st.peek();
    }
}
