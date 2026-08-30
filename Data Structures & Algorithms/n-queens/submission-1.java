class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, n, res);
        return res;
    }

    public void backtrack(char[][] board, int col, int n, List<List<String>> res) {
        if(col==n) {
            res.add(buildBoard(board));
            return;
        }

        for(int row=0; row<n; row++) {
            if(validBoard(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, col+1, n, res);
                board[row][col] = '.';
            }
        }
    }

    public boolean validBoard(char[][] board, int row, int col, int n) {
        // check the full column if Q exists
        for(int r=0; r<n; r++) {
            if(board[r][col]=='Q')
                return false;
        }

        // check the full row if Q exists
        for(int c=0; c<n; c++) {
            if(board[row][c]=='Q')
                return false;
        }

        // check 45 degree diaganol towards bottom left
        int i = row+1;
        int j = col-1;

        while(i<n && j>=0) {
            if(board[i][j]=='Q')
                return false;
            i++;
            j--;
        }

        // check upper left diagonal
        i = row-1;
        j = col-1;

        while(i>=0 && j>=0) {
            if(board[i][j]=='Q')
                return false;
            i--;
            j--;
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
