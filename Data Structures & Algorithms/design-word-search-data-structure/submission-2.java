class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return find(word, root, 0);
    }

    public boolean find(String word, TrieNode root, int index) {
        TrieNode cur = root;
        char c = word.charAt(index);
        // base case check if last char is matching
        if (index == word.length() - 1) {
            // if it's '.'
            // check all children at current node to see if they've end of word true
            if (c == '.') {
                for (TrieNode child : cur.children.values()) {
                    if (child.endOfWord)
                        return true;
                }
                return false;
            } else {
                // last char is not '.'
                if(cur.children.containsKey(c) && cur.children.get(c).endOfWord == true)
                    return true;
                else {
                    return false;
                }
            }
        } 

        // not checking last character
        if(word.charAt(index)!='.') {
            // not period
            if(cur.children.containsKey(c)) {
                return find(word, cur.children.get(c), index+1);
            } else {
                return false;
            }
        } else {
            // we're checking period when not last index
            // iterate over all the chars
            for(TrieNode child: cur.children.values()) {
                if(find(word, child, index+1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
