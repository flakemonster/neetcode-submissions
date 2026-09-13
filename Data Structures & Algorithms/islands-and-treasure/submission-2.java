class Solution {
    int ROWS = 0;
    int COLS = 0;
    public void islandsAndTreasure(int[][] grid) {
        // do a multi source bfs from the treasures
        Queue<Pair<Integer, Integer>> dq = new ArrayDeque<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Pair<Integer, Integer> pair;
        ROWS = grid.length;
        COLS = grid[0].length;

        // add treasures to dq
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(grid[i][j]==0) {
                    pair = new Pair<>(i, j);
                    dq.add(pair);
                    visited.add(pair);
                }
            }
        }

        if (dq.size() == 0) return;
        // now do a multi source bfs from these treasures
        int dist = 0;

        while(!dq.isEmpty()) {
            int size = dq.size();
            for(int i=0; i<size; i++) {
                pair = dq.poll();
                int r = pair.getKey();
                int c = pair.getValue();
                grid[r][c] = dist;

                // now add to q
                addToQ(grid, r-1, c, dq, visited);
                addToQ(grid, r+1, c, dq, visited);
                addToQ(grid, r, c-1, dq, visited);
                addToQ(grid, r, c+1, dq, visited);
            }
            // increment dist once we've visited all lands from the treasures at that level
            dist++;
        }
    }

    public void addToQ(int[][] grid, int r, int c, Queue<Pair<Integer, Integer>> dq, Set<Pair<Integer, Integer>> visited) {
        Pair<Integer, Integer> pair = new Pair<>(r, c);
        // check boundary conditions
        if(r<0||r==ROWS||c<0||c==COLS||grid[r][c]==-1||visited.contains(pair)) {
            return;
        }

        dq.add(pair);
        visited.add(pair);
    }
}
