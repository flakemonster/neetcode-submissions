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
    public int maxDepth(TreeNode root) { 
        return maxDepthHelper(root, 1);
    }

    public int maxDepthHelper(TreeNode root, int count) {
        if(root == null)
            return 0;
        
        int leftCount = 1 + maxDepthHelper(root.left, count+1);
        int rightCount = 1 + maxDepthHelper(root.right, count+1);
        return Math.max(leftCount, rightCount);
    }
}
