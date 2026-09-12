class Solution {
    int ROWS = 0;
    int COLS = 0;
    public void islandsAndTreasure(int[][] grid) {
        // queue for bfs
        Queue<Pair<Integer, Integer>> dq = new ArrayDeque<>();
        // set for counting what has been visited
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Pair<Integer, Integer> pair;
        ROWS = grid.length;
        COLS = grid[0].length;

        // now check what are all the treasure chests, add them to queue
        // so we can do a multi source bfs from there.
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    // do a bfs by adding the value to Deque
                    pair = new Pair<>(i, j);
                    dq.add(pair);
                    visited.add(pair);
                }
            }
        }

        // now that all treasures are added to queue, do a bfs on them
        int dist = 0;
        int r, c;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                pair = dq.poll();
                r = pair.getKey();
                c = pair.getValue();
                grid[r][c] = dist;
                // down
                addToQueue(r + 1, c, dq, visited, grid);
                // up
                addToQueue(r - 1, c, dq, visited, grid);
                // right
                addToQueue(r, c + 1, dq, visited, grid);
                // left
                addToQueue(r, c - 1, dq, visited, grid);
            }
            dist++;
        }
    }

    public void addToQueue(int r, int c, Queue<Pair<Integer, Integer>> dq, Set<Pair<Integer, Integer>> visited, int[][] grid) {
        Pair<Integer, Integer> pair = new Pair<>(r, c);
        // check boundary conditions
        if(r<0 || r==ROWS || c<0 || c==COLS || grid[r][c]==-1 || visited.contains(pair)) {
            return;
        }


        // add to dq
        dq.add(pair);
        // add pair to visited set
        visited.add(pair);
    }
}
