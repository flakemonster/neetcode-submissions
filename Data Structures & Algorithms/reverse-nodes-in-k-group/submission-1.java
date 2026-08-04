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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp, nextNode, prevNode = null;

        tmp = head;

        while(tmp != null) {
            ListNode kthNode = getKthNode(tmp, k);
            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = tmp;
                }
                break;
            }
            // nextNode isn't pointing to corrected node yet, but unreversed kth's next
            nextNode = kthNode.next;
            kthNode.next = null;
            
            reverse(tmp);
        
            if(tmp == head) {
                head = kthNode;
                // prevNode is null, don't need to do anything there.
            }  else {
                // update prevNode's connection to kthNode

                prevNode.next = kthNode;
            }
            prevNode = tmp;
            tmp = nextNode;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head, tmp, prev = null;
        while(curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        head = prev;
        return prev;
    }

    private ListNode getKthNode(ListNode head, int k) {
        ListNode curr = head;

        while(k>1) {
            if(curr == null) {
                return null;
            } 
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
