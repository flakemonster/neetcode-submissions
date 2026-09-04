class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String wordAtEnd; // terminal char has the full word
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String word: words) {
            buildTrie(root, word);
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        //System.out.println("i "+i+" j "+j+" board "+board[i][j]);
        // base conditions
        // terminate dfs if the letter isn't in trie
        // or if we're already visiting a visited char
        if(!root.children.containsKey(board[i][j]) || board[i][j]=='#') {
            return;
        }

        TrieNode child = root.children.get(board[i][j]);
        // otherwise if it's the end of word, then we should add it to result
        if(child.wordAtEnd != null) {
            res.add(child.wordAtEnd);
            child.wordAtEnd = null;
        }

        // choice
        // mark char as visited
        char tmp = board[i][j];
        board[i][j] = '#';

        // backtrack
        if(i>0) // go up
            dfs(board, i-1, j, child, res);
        if(j>0) // go left
            dfs(board, i, j-1, child, res);
        if(i<board.length-1) // go down
            dfs(board, i+1, j, child, res);
        if(j<board[0].length-1) // go right
            dfs(board, i, j+1, child, res);
        
        // undo choice
        board[i][j] = tmp;
    }
    public void buildTrie(TrieNode root, String word) {
        TrieNode cur = root;

        for(char c: word.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.wordAtEnd = word;
    }
}
