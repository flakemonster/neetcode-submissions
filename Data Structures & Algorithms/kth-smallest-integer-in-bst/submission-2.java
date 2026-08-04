/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        st.push(cur);
        int c = 0;

        while(!st.isEmpty()) {
            while(cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            c++;
            if(c == k)
                return cur.val;
            cur = cur.right;
        }
        return -1;
    }
}
