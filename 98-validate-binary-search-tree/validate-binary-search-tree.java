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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return validate(root);
    }

    public boolean validate(TreeNode node){

        if(node == null){
            return true;
        }

        boolean isValidL = validate(node.left);
        if(prev != null && prev.val >= node.val){
            return false;
        }

        prev = node;
        boolean isValidR = validate(node.right);

        return isValidL && isValidR;
    }
}