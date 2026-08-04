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
                System.out.println("kth Node is null, return list as is now");
                if(prevNode != null) {
                    prevNode.next = tmp;
                    System.out.println("prevNode is "+prevNode.val+" it's next is "+tmp.val);
                }
                break;
            }
            // nextNode isn't pointing to corrected node yet, but unreversed kth's next
            nextNode = kthNode.next;
            kthNode.next = null;
            
            reverse(tmp);
            if(tmp == head) {
                head = kthNode;
            }  else {
                // update prevNode
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
        System.out.println("reversed list ");
        curr = head;
        while(curr != null) {
            System.out.print(" "+curr.val);
            curr = curr.next;
        }
        System.out.println(" ");
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
        //System.out.println("kth node is "+curr.val);
        return curr;
    }
}
