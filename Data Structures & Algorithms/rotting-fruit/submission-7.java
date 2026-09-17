class Solution {
    int ROWS = 0;
    int COLS = 0;
    int freshCount = 0;
    public int orangesRotting(int[][] grid) {
        // multi source bfs
        Queue<Pair<Integer, Integer>> dq = new ArrayDeque<>();
        HashSet<Pair<Integer, Integer>> rotten = new HashSet<>();
        Pair<Integer, Integer> pair;
        ROWS = grid.length;
        COLS = grid[0].length;
        
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(grid[i][j]==1) {
                    freshCount++;
                }
                if(grid[i][j]==2) {
                    pair = new Pair<>(i, j);
                    dq.add(pair);
                    rotten.add(pair);
                }
            }
        }

        if(dq.isEmpty()) {
            if(freshCount!=0)
                return -1;
            else {
                return 0;
            }
        }
        
        int time = -1;
        while(!dq.isEmpty()) {
            int size = dq.size();
            for(int i=0; i<size; i++) {
                pair = dq.poll();
                int r = pair.getKey();
                int c = pair.getValue();
                grid[r][c] = 2;
                rotten.add(pair);
                addToQ(grid, r+1, c, dq, rotten);
                addToQ(grid, r-1, c, dq, rotten);
                addToQ(grid, r, c+1, dq, rotten);
                addToQ(grid, r, c-1, dq, rotten);
            }
            time++;
        }
        System.out.println("freshCOunt "+freshCount+" time "+time);
        return freshCount==0?time:-1;
    }

    public void addToQ(int[][] grid, int r, int c, Queue<Pair<Integer, Integer>> dq, Set<Pair<Integer, Integer>> rotten) {
        // check boundary conditions
        Pair<Integer, Integer> pair = new Pair<>(r, c);
        if(r<0||r==ROWS||c<0||c==COLS||rotten.contains(pair)||grid[r][c]==0)
            return;
        if(grid[r][c]==1) {
            freshCount--;
        }
        dq.add(pair);
        rotten.add(pair);
    }
}
