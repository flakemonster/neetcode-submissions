class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, new StringBuilder(), res, 0, 0);

        return res;
    }

    public void backtrack(int n, StringBuilder sb, List<String> res, int open, int close) {
        if(close == n) {
            // this is a parenthesis combination
            // number of closed parenthesis are equal to n
            res.add(sb.toString());
            return;
        }

        // check if close can be added
        if(close < open) {
            sb.append(')');
            backtrack(n, sb, res, open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }

        // check if open can be added
        if(open < n) {
            sb.append('(');
            backtrack(n, sb, res, open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
