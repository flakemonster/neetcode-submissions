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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 || lists==null)
            return null;

        while(lists.length>1) {
            ArrayList<ListNode> mergedLists = new ArrayList<ListNode>();
            for(int i=0; i<lists.length;){
                ListNode l1 = lists[i];
                ListNode l2 = (i+1)>=lists.length?null:lists[i+1];
                mergedLists.add(merge2SortedLists(l1, l2));
                i=i+2;
            }
            lists = mergedLists.toArray(new Main.ListNode[0]);
        }
        return lists[0];
    }

    public ListNode merge2SortedLists(ListNode l1, ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode dummyHead = new ListNode();
        ListNode res = dummyHead;
        while(l1!=null && l2!=null) {
            if(l1.val<=l2.val){
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if(l1!=null){
            res.next = l1;
        }

        if(l2!=null){
            res.next = l2;
        }
        return dummyHead.next;
    }
}
