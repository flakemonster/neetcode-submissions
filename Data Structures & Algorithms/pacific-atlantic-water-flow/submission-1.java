class Solution {
    int ROWS = 0;
    int COLS = 0;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Pair<Integer, Integer>> pac, atl;
        pac = new HashSet<>();
        atl = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        ROWS = heights.length;
        COLS = heights[0].length;

        // first do top and bottom to see what reaches, atl, pac
        for(int c=0; c<COLS; c++) {
            // first check from top i.e pac
            dfs(0, c, heights[0][c], pac, heights);
            // check from bottom i.e atl
            dfs(ROWS-1, c, heights[ROWS-1][c], atl, heights);
        }

        // now do left and right to see what reaches atl, pac
        for(int r=0; r<ROWS; r++) {
            // check from left i.e pac
            dfs(r, 0, heights[r][0], pac, heights);
            // check from right i.e atl
            dfs(r, COLS-1, heights[r][COLS-1], atl, heights);
        }

        // now check the result, if any pair in both atl, pac
        // add to res
        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                Pair<Integer, Integer> pair = new Pair<>(r, c);
                if(pac.contains(pair) && atl.contains(pair)) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    public void dfs(int r, int c, int prevHeight, Set<Pair<Integer, Integer>> visit, int[][] heights) {
        Pair<Integer, Integer> pair = new Pair<>(r, c);
        if(r<0 || r==ROWS || c<0 || c==COLS || visit.contains(pair) ||
            prevHeight > heights[r][c]) {
                return;
            }

        visit.add(pair);
        dfs(r+1, c, heights[r][c], visit, heights);
        dfs(r-1, c, heights[r][c], visit, heights);
        dfs(r, c+1, heights[r][c], visit, heights);
        dfs(r, c-1, heights[r][c], visit, heights);
    }
}
