/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head==null)
            return head;

        ListNode slow, fast, tmp, curr;
        ListNode dummy=new ListNode(-1, head);
        
        // point slow ptr before head by creating dummy node.
        slow = dummy;
        
        fast=head;

        //point fast n steps ahead
        for(int i=0; i<n; i++) {
            fast=fast.next;
        }

        // now the race between, slow and fast
        while(fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        if(slow.next==head){
            head = head.next;
            return head;
        }
        System.out.println("node to delete = "+slow.next.val);
        if(slow.next!=null) {
            ListNode nodeToDelete=slow.next;

            tmp=nodeToDelete.next;
            slow.next=tmp;

        }
        return head;
    }
}
