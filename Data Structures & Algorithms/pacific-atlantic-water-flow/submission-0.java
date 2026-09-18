class Solution {
    int ROWS = 0;
    int COLS = 0;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        HashSet<Pair<Integer, Integer>> atl = new HashSet<>();
        HashSet<Pair<Integer, Integer>> pac = new HashSet<>();

        // see what cells from pac and atl are visited top, bottom
        for(int c=0; c<COLS; c++) {
            // go from pacific
            dfs(0, c, pac, heights[0][c], heights);

            // go from atl
            dfs(ROWS-1, c, atl, heights[ROWS-1][c], heights);
        }

        // see what cells from pac and atl are visited left, right
        for(int r=0; r<ROWS; r++) {
            // go from pacific
            dfs(r, 0, pac, heights[r][0], heights);

            // go from atl
            dfs(r, COLS-1, atl, heights[r][COLS-1], heights);
        }

        // see what are in both atl and pac, add to list
        List<List<Integer>> res = new ArrayList<>();

        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                Pair<Integer, Integer> pair = new Pair<>(r, c);
                if(pac.contains(pair) && atl.contains(pair)) {
                    res.add(Arrays.asList(pair.getKey(), pair.getValue()));
                } 
            }
        }

        return res;
    }


    public void dfs(int r, int c, Set<Pair<Integer, Integer>> visit, int prevHeight, int[][] heights) {
        Pair<Integer, Integer> pair = new Pair<>(r, c);
        if(r<0 || r==ROWS || c<0 || c==COLS || visit.contains(pair) || prevHeight>heights[r][c]) {
            return;
        }

        // now visit the cell
        visit.add(pair);

        dfs(r+1, c, visit, heights[r][c], heights);
        dfs(r-1, c, visit, heights[r][c], heights);
        dfs(r, c+1, visit, heights[r][c], heights);
        dfs(r, c-1, visit, heights[r][c], heights);
    }
}
