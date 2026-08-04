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
    int count = 0;
    public int goodNodes(TreeNode root) {
        goodNodesHelper(root, root.val);
        return count;
    }

    public void goodNodesHelper(TreeNode root, int maxValSoFar) {
        if(root == null)
            return;
        if(maxValSoFar<=root.val) {
            maxValSoFar = root.val;
            count++;
        }   
        goodNodesHelper(root.left, maxValSoFar);
        goodNodesHelper(root.right, maxValSoFar);
    }
}
