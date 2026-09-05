class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String wordAtEnd;
    }

    public void insertWord(TrieNode root, String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.wordAtEnd = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        // first insert all words into trie
        TrieNode root = new TrieNode();
        for(String word: words) {
            insertWord(root, word);
        }

        // now do a dfs backtracking on all the letters of grid
        // if a letter doesn't show up in trie, then prune the search
        // undo and move to next
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                //System.out.println("findwords visiting "+board[i][j]);
                backtracking(board, i, j, root, res);
            }
        }

        return res;
    }

    public void backtracking(char[][] board, int i, int j, TrieNode root, List<String> res) {
        // terminal condition
        // the cases which are invalid, you return without doing anything
        // 1. if char is already visited
        // 2. if there's no such child
        //System.out.println("visiting "+board[i][j]);
        if(!root.children.containsKey(board[i][j]) || board[i][j]=='#') {
            //System.out.println("returning");
            return;
        }

        // if it's a valid condition where it's the end of word
        TrieNode child = root.children.get(board[i][j]);
        if(child.wordAtEnd != null) {
            //System.out.println("wordAtEnd not null, add to res "+child.wordAtEnd);
            res.add(child.wordAtEnd);
            // mark the word as not terminal by removing '#'
            child.wordAtEnd = null;
        }

        // mark child node visited
        char tmp = board[i][j];
        board[i][j] = '#';
        // move up
        if(i>0) {
            //System.out.println("moving up");
            backtracking(board, i-1, j, child, res);
        }

        // move left
        if(j>0) {
            //System.out.println("moving left");
            backtracking(board, i, j-1, child, res);
        }

        // move down
        if(i<board.length-1) {
            //System.out.println("moving down");
            backtracking(board, i+1, j, child, res);
        }

        // move right
        if(j<board[0].length-1) {
            //System.out.println("moving right");
            backtracking(board, i, j+1, child, res);
        }

        //System.out.println("end of backtracking, undo choice for "+tmp);
        // undo choice
        board[i][j] = tmp;
    }
}
