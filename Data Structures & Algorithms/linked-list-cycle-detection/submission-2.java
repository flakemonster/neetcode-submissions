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
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;
        // fast and slow pointer
        ListNode slow, fast;
        slow=head;
        fast=head.next;

        while(slow!=null && fast!=null) {
            if(slow==fast){
                return true;
            }
            slow = slow.next;
            if(fast.next!=null)
                fast=fast.next.next;
            else // fast.next is null, so end of list, no cycle.
                return false;
        }
        return false;
    }
}
