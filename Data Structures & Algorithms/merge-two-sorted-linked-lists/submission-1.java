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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        
        ListNode ptr1=list1, ptr2=list2;
        ListNode res=null, resHead=null;
        // as long as both lists have elements
        // in result list keep adding these elements whichever is coming first
        while(ptr1!=null && ptr2!=null) {
            if(resHead==null) {
                if(ptr1.val<=ptr2.val){
                    resHead=ptr1;
                    ptr1=ptr1.next;
                } else {
                    // ptr2 is smaller
                    resHead=ptr2;
                    ptr2=ptr2.next;
                }
                res=resHead;
            } else {
                // we already have resHead populated, now lets look at other cases
                if(ptr1.val<=ptr2.val) {
                    res.next=ptr1;
                    ptr1=ptr1.next;
                } else {
                    res.next=ptr2;
                    ptr2=ptr2.next;
                }
                res=res.next;
            }
        }

        // if there are still elements in ptr1
        if(ptr1!=null) {
            res.next=ptr1;
        }
        if(ptr2!=null) {
            res.next=ptr2;
        }
        return resHead;
    }
}