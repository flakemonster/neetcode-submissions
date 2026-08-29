class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[0].length; c++) {
                board[r][c] = '.';
            }
        }
        backtrack(board, 0, n, res);
        return res;
    }

    public void backtrack(char[][] board, int row, int n, List<List<String>> res) {
        if(row == n) {
            res.add(buildChess(board));
            return;
        }

        for(int col=0; col<n; col++) {
            if(validChess(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row+1, n, res);
                board[row][col] = '.';
            }
        }
    }

    public boolean validChess(char[][] board, int row, int col, int n) {
        // check if Q exists in the same column

        for(int i=0; i<n; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // check if Q exists in 45 degree diagnol
        int i = row-1;
        int j = col+1;
        while(i>=0 && j<n) {
            if(board[i][j]=='Q')
                return false;
            i--;
            j++;
        }

        // check if Q exists in 135 degree diagnol
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

    public List<String> buildChess(char[][] board) {
        List<String> path = new ArrayList<>();

        for(int i=0; i<board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
