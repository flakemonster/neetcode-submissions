class Solution {
    public int numIslands(char[][] grid) {
        // simple
        // whenever you encounter 1, make it 0, for all the neighboring 1's
        // increment islands before making 0

        int islands = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int i, int j) {
        // boundary check
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0') {
            return;
        }

        // now to mark visited, you can change the value of that 1 to 0
        grid[i][j] = '0';

        // now check neighbors
        // up
        dfs(grid, i+1, j);
        // down
        dfs(grid, i-1, j);
        // left
        dfs(grid, i, j-1);
        // right
        dfs(grid, i, j+1); 
    }
}
