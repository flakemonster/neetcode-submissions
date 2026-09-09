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
        return clone(node, oldToNew);
    }

    public Node clone(Node node, HashMap<Node, Node> oldToNew) {
        if(oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        // if map doesn't contain clone
        // 1. create clone
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        // 2. copy the neighbors
        for(Node neighbor: node.neighbors) {
            copy.neighbors.add(clone(neighbor, oldToNew));
        }

        return copy;
    }
}