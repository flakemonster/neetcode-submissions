/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        HashMap<Node, Node> oldToNew = new HashMap<>();
        clone(node, oldToNew);
        return oldToNew.get(node);
    }

    public Node clone(Node root, HashMap<Node, Node> oldToNew) {
        if(oldToNew.containsKey(root))
            return oldToNew.get(root);
        
        // if map doesn't contain root
        // create the copy first
        Node copy = new Node(root.val);
        oldToNew.put(root, copy);

        // now loop over neighbors of root
        for(int i=0; i<root.neighbors.size(); i++) {
            Node neiCopy = clone(root.neighbors.get(i), oldToNew);
            copy.neighbors.add(neiCopy);
        }
        return copy;
    }
}