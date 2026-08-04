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
        if(head==null)
            return null;
        Node curr=head;

        // 1. create new nodes with same values and store them as next to current node
        while(curr!=null) {
            Node newNode = new Node(curr.val);
            Node tmp = curr.next;
            curr.next=newNode;
            newNode.next=tmp;
            curr=newNode.next;
        }

        System.out.println("after creating new nodes, list is ");
        curr=head;
        while(curr.next!=null){
            System.out.println(curr.val+" -> "+curr.next.val);
            curr=curr.next;
        }

        // 2. copy the random pointers to the new node, they're empty currently
        curr = head;
        while(curr!=null) {
            System.out.println(" setting random for "+curr.val);
            if(curr.random!=null)
                curr.next.random=curr.random.next;
            curr=curr.next.next;
        }

        // 3. separate the lists now that we've the random, values populated properly
        //    We need to have the next pointers corrected for original and copied nodes
        curr = head;
        Node newCurr = head.next;
        Node newHead = head.next;

        while(curr!=null && newCurr!=null) {
            curr.next = newCurr.next;
            curr = newCurr.next;

            if(newCurr.next!=null) {
                newCurr.next = curr.next;
                newCurr = curr.next;
            }
        }
        return newHead;
    }
}
