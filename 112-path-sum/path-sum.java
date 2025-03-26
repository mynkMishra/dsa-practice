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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, 0, targetSum);
    }

    public boolean solve(TreeNode node, int sum, int targetSum){

        if(node == null){
            return false;
        }

        if(node.left == null && node.right == null){
            if(targetSum == sum + node.val){
                return true;
            }

            return false;
        }
        
        boolean l = solve(node.left, sum + node.val, targetSum);

        if(l){
            return true;
        }

        boolean r = solve(node.right, sum + node.val, targetSum);

        return l || r;
    }
}