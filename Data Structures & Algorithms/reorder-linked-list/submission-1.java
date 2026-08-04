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
    public void reorderList(ListNode head) {
        ListNode slow, fast;
        if(head==null||head.next==null)
            return;
        slow=head;
        fast=head.next;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        // now the left list that's from head through slow ptr is l1
        // step 2: reverse the list from slow.next -> end
        ListNode curr=slow.next, tmp, prev=null;
        // sever the list from mid
        slow.next=null; // list l1 is from head till slow

        // reversing list from slow.next to end.
        while(curr!=null) {
            tmp=curr.next;
            curr.next=prev;

            // go to the next node
            prev=curr;
            curr=tmp;
        }

        // now 2 lists
        // l1 (from head till slow)
        // l2 (from prev ptr till slow.next in reverse)
        ListNode l1=head, l2=prev, res=null;


        // merge the 2 lists alternately
        while(l1!=null && l2!=null) {
            // first merge one from l1
            if(res==null) {
                res=l1;
            } else {
                res.next=l1;
                res=res.next;
            }
            l1=l1.next;

            // then merge one from l2
            res.next=l2;
            l2=l2.next;

            res=res.next;
        }

        if(l1!=null)
            res.next=l1;
        
        if(l2!=null)
            res.next=l2;
    }
}
