class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[0].length; c++) {
                if(board[r][c]==word.charAt(0)) {
                    if(backtrack(board, word, 0, r, c))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int index, int row, int col) {
        if(index == word.length()) {
            return true;
        }

        if(row<0 || row >= board.length || col < 0 || col >=board[0].length || word.charAt(index)!=board[row][col]) {
            return false;
        } 

        char tmp = board[row][col];
        board[row][col] = '#';
        // now traverse the next ones
        boolean res = backtrack(board, word, index+1, row-1, col) || backtrack(board, word, index+1, row+1, col) || backtrack(board, word, index+1, row, col+1) || backtrack(board, word, index+1, row, col-1);

        board[row][col] = tmp;
        return res;
    }
}
