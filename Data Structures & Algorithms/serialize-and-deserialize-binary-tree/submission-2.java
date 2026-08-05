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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = serializeHelper(root).toString();
        System.out.println(res);
        return res;
    }

    public StringBuilder serializeHelper(TreeNode root) {
        if(root == null)
            return new StringBuilder("N ");
        
        StringBuilder res = new StringBuilder();
        res.append(root.val+" ");
        res.append(serializeHelper(root.left));
        res.append(serializeHelper(root.right));
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = new int[1]; 
        index[0] = 0;
        return deserializeHelper(data, index);
    }

    public TreeNode deserializeHelper(String data, int[] index) {       
        int i = index[0];
        if(index[0]>=data.length()||data.charAt(i) == 'N') {
            return null;
        }
        
        
        while(data.charAt(index[0])!=' ') {
            index[0]++;
        }
        
        int val = Integer.parseInt(data.substring(i, index[0]));

        //make sure index isn't pointing to delimiter anymore
        index[0]--;
        TreeNode root = new TreeNode(val);

        // double increment index, so we're never pointing to delimiter
        index[0]++;
        index[0]++;
        root.left = deserializeHelper(data, index);

        // double increment index so we're never pointing to delimiter
        index[0]++;
        index[0]++;
        root.right = deserializeHelper(data, index);
        return root;
    }
}
