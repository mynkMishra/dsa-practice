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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    public TreeNode merge(TreeNode n1,TreeNode n2){

        if(n1 == null && n2 == null){
            return null;
        }

        if(n1 == null){
            TreeNode newNode = new TreeNode(n2.val);
            TreeNode lT = merge(null, n2.left);
            TreeNode rT = merge(null, n2.right);
            newNode.left = lT;
            newNode.right = rT;

            return newNode;
        }

        if(n2 == null){
            TreeNode newNode = new TreeNode(n1.val);
            TreeNode lT = merge(n1.left, null);
            TreeNode rT = merge(n1.right, null);
            newNode.left = lT;
            newNode.right = rT;

            return newNode;
        }

        TreeNode lT = merge(n1.left, n2.left);
        TreeNode rT = merge(n1.right, n2.right);

        TreeNode newNode = new TreeNode(n1.val + n2.val);
        newNode.left = lT;
        newNode.right = rT;

        return newNode;
    }
}