class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        
        for(int row=0; row<9; row++) {
            for (int col=0; col<9; col++) {
                if (board[row][col]=='.') {
                    continue;
                }
                char num = board[row][col];
                boolean seenAtRow = seen.add(num+" added at row "+row);
                boolean seenAtCol = seen.add(num+" added at col "+col);
                boolean seenAtBox = seen.add(num+" added at box "+(row/3)+" - "+(col/3));
                if (!seenAtRow || !seenAtCol || !seenAtBox) {
                    return false;
                }
            }
        }
        return true;
    }
}
