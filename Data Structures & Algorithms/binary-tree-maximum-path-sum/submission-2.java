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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    public int maxPathSumHelper(TreeNode root) {
        if(root == null)
            return 0;
        int leftSum = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);
        leftSum = leftSum>0?leftSum:0;
        rightSum = rightSum>0?rightSum:0;
        //System.out.println("leftSum "+leftSum+" rightSum "+rightSum+" root.val "+root.val);
        maxSum = Math.max(maxSum, root.val+leftSum+rightSum);
        System.out.println("finally visiting "+root.val);
        System.out.println("leftSum "+leftSum+" rightSum "+rightSum+" maxSum "+maxSum);
        return root.val+Math.max(leftSum, rightSum);
    }
}
