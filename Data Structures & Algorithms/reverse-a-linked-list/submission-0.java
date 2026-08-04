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
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        
        ListNode curr, tmp, prev=null;
        curr=head;

        while(curr!=null) {
            tmp=curr.next;
            curr.next=prev;


            // move prev and curr
            prev=curr;
            curr=tmp;
        }
        head=prev;
        return head;
    }
}
