class Solution {
    int ROWS = 0;
    int COLS = 0;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        // first check in borders at to what values are 'o'
        // mark 'o' at border as 't' in dfs
        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(r==0 || r==ROWS-1 || c==0 || c==COLS-1)
                    dfs(board, r, c);
            }
        }

        // mark all other 'o's that are fully surrounded by 'x' as 'x'
        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(board[r][c]=='O') {
                    if(board[r-1][c]!='t' && board[r+1][c]!='t' && board[r][c-1]!='t' && board[r][c+1]!='t') {
                        // mark this region as surrounded as 'x'
                        board[r][c] = 'X';
                    }
                }
            }
        }

        // now mark all 't's as 'O'
        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(board[r][c]=='t')
                    board[r][c] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int r, int c) {
        if(r<0 || r==ROWS || c<0 || c==COLS || board[r][c]!='O')
            return;
        
        board[r][c] = 't';
        dfs(board, r-1, c);
        dfs(board, r+1, c);
        dfs(board, r, c-1);
        dfs(board, r, c+1);
    }
}
