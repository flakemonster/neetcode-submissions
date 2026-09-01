class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> rows = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> upperLeftDiagonal = new ArrayList<>(Collections.nCopies(2*n-1, 0));
        List<Integer> lowerLeftDiagonal = new ArrayList<>(Collections.nCopies(2*n-1, 0));
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(board[i], '.');
        
        backtrack(board, 0, n, rows, upperLeftDiagonal, lowerLeftDiagonal, res);

        return res;
    }

    public void backtrack(char[][] board, int col, int n, List<Integer> rows, List<Integer> upperLeftDiagonal, List<Integer> lowerLeftDiagonal, List<List<String>> res) {
        if(col == n) {
            res.add(buildBoard(board));
            return;
        }

        for(int r=0; r<n; r++) {
            // now check the conditions
            // if it's safe to place, then do backtracking
            if(rows.get(r)==0 && upperLeftDiagonal.get(col+r)==0 && lowerLeftDiagonal.get(n-1+r-col)==0) {
                // safe to place

                // choice
                board[r][col] = 'Q';
                rows.set(r, 1);
                upperLeftDiagonal.set(r+col, 1);
                lowerLeftDiagonal.set(n-1+r-col, 1);

                // backtrack
                backtrack(board, col+1, n, rows, upperLeftDiagonal, lowerLeftDiagonal, res);

                // undo choice
                board[r][col] = '.';
                rows.set(r, 0);
                upperLeftDiagonal.set(r+col, 0);
                lowerLeftDiagonal.set(n-1+r-col, 0);
            }
        }
    }

    public List<String> buildBoard(char[][] board) {
        List<String> path = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
