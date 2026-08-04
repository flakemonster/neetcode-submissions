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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        max = Math.max(max, leftDepth+rightDepth);
        System.out.println("node "+root.val+" leftDepth "+leftDepth+" rightDepth "+rightDepth+" max "+max);
        return 1+Math.max(leftDepth, rightDepth);
    }
}
