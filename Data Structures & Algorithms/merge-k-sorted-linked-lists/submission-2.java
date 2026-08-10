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
        PriorityQueue<Pair<Integer, ListNode>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for(int i=0; i<lists.length; i++) {
            if(lists[i]!=null) {
                Pair<Integer, ListNode> pair = new Pair<>(lists[i].val, lists[i]);
                minHeap.add(pair);
            }
        }

        while(!minHeap.isEmpty()) {
            Pair<Integer, ListNode> pair = minHeap.poll();
            int val = pair.getKey();
            ListNode node = pair.getValue();
            cur.next = node;
            cur = cur.next;
            node = node.next;

            // now push the updated node to heap
            if(node != null)
                minHeap.add(new Pair<Integer, ListNode>(node.val, node));
        }

        return dummy.next;
    }
}
