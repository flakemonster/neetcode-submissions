/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Hashmap to map old and copy node in first pass
        // 2nd pass to map next and random ptrs

        HashMap<Node, Node> oldToCopy=new HashMap<>();
        Node curr=head;
        while(curr!=null) {
            oldToCopy.put(curr, new Node(curr.val));
            curr=curr.next;
        }
        //oldToCopy.put(null, null);
        curr=head;

        while(curr!=null) {
            oldToCopy.get(curr).next=oldToCopy.get(curr.next);
            oldToCopy.get(curr).random=oldToCopy.get(curr.random);
            curr=curr.next;
        }
        return oldToCopy.get(head);
    }
}
