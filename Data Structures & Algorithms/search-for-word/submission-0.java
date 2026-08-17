class Solution {
    public boolean exist(char[][] board, String word) {
        // loop through all cells to find starting letter

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // found first letter
                    // now do the back tracking
                    if (backtrack(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int wordIndex, int i, int j) {
        // if word is equal to this, return true
        if (wordIndex == word.length()) {
            return true;
        }

        // check out of bounds
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j]!=word.charAt(wordIndex))
            return false;

        char temp = board[i][j];

        // mark current char as visited by using #
        board[i][j] = '#'; 
        boolean found = backtrack(board, word, wordIndex+1, i, j+1) || backtrack(board, word, wordIndex+1, i, j-1)
                        || backtrack(board, word, wordIndex+1, i-1, j) || backtrack(board, word, wordIndex+1, i+1, j);
        
        board[i][j] = temp;
        return found;
    }
}
