class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++) board[r][c] = '.';

        backtrack(board, 0, res, n);
        return res;
    }

    public void backtrack(char[][] board, int col, List<List<String>> res, int n) {
        if (col == n) {
            res.add(buildBoard(board));
            return;
        }

        for (int r = 0; r < n; r++) {
            if(validBoard(board, r, col, n)) {
                // choice
                board[r][col] = 'Q';

                // backtrack on next column
                backtrack(board, col + 1, res, n);

                // undo choice
                board[r][col] = '.';
            }
        }
    }

    public boolean validBoard(char[][] board, int row, int col, int n) {
        // check the row if Q already exists
        for(int c=0; c<col; c++) {
            if(board[row][c]=='Q')
                return false;
        }

        // check if col already has Q
        for(int r=0; r<row; r++) {
            if(board[r][col]=='Q')
                return false;
        }

        // check upper left diagonal if it already has Q
        int r = row-1;
        int c = col-1;
        while(r>=0 && c>=0) {
            if(board[r][c]=='Q')
                return false;
            
            r--;
            c--;
        }

        // check bottom left diagonal if it already has Q
        r = row+1;
        c = col-1;
        while(r<n && c>=0) {
            if(board[r][c]=='Q')
                return false;

            r++;
            c--;
        }
        return true;
    }

    public List<String> buildBoard(char[][] board) {
        List<String> path = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
