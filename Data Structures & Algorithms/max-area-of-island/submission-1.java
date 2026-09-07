class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int[] curArea = new int[1];
        curArea[0]=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1)
                    dfs(grid, i, j, 0);
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j, int area) {
        // check boundary conditions first
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0) {
            return area;
        }

        grid[i][j]=0;
        area += 1 + dfs(grid, i+1, j, area) + dfs(grid, i-1, j, area)
                  + dfs(grid, i, j+1, area) + dfs(grid, i, j-1, area);
        maxArea = Math.max(area, maxArea);
        return area;
    }
}
