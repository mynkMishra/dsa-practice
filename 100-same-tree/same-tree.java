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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    public boolean dfs(TreeNode a, TreeNode b){

        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null || a.val != b.val){
            return false;
        }
        boolean isValidL = dfs(a.left, b.left);
        boolean isValidR = dfs(a.right, b.right);

        return isValidL && isValidR;
    }
}