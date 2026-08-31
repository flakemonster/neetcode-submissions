class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> leftDiagonal = new ArrayList<>(Collections.nCopies((2*n)-1, 0));
        ArrayList<Integer> rightDiagonal = new ArrayList<>(Collections.nCopies((2*n)-1, 0));
        
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++) board[r][c] = '.';

        backtrack(board, 0, res, n, rows, leftDiagonal, rightDiagonal);
        return res;
    }

    public void backtrack(char[][] board, int col, List<List<String>> res, int n, List<Integer> rows, List<Integer> leftDiagonal, List<Integer> rightDiagonal) {
        if (col == n) {
            res.add(buildBoard(board));
            return;
        }

        for (int r = 0; r < n; r++) {
            if(rows.get(r)==0 && leftDiagonal.get(r+col)==0 && rightDiagonal.get((n-1)+r-col)==0) {
                // choice
                board[r][col] = 'Q';
                rows.set(r, 1);
                leftDiagonal.set(r+col, 1);
                rightDiagonal.set((n-1)+r-col, 1);

                // backtrack on next column
                backtrack(board, col+1, res, n, rows, leftDiagonal, rightDiagonal);

                // undo choice
                rows.set(r, 0);
                leftDiagonal.set(r+col, 0);
                rightDiagonal.set((n-1)+r-col, 0);
                board[r][col] = '.';
            }

            // if(validBoard(board, r, col, n)) {
            //     // choice

            //     board[r][col] = 'Q';

            //     // backtrack on next column
            //     backtrack(board, col + 1, res, n);

            //     // undo choice
            //     board[r][col] = '.';
            // }
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
