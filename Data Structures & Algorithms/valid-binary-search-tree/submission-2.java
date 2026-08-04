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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, int minVal, int maxVal) {
        if(root == null)
            return true;
        
        if(minVal < root.val && root.val < maxVal)
            return isValidBSTHelper(root.left, minVal, root.val) 
                && isValidBSTHelper(root.right, root.val, maxVal);
        
        return false;
    }
}
