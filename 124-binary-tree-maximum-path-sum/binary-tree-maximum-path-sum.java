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

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){

        if(root == null){
            return -1001;
        }

        int lSum = dfs(root.left);
        int rSum = dfs(root.right);

        int val = Math.max(root.val, Math.max(root.val + lSum, root.val + rSum));

        ans = Math.max( root.val + lSum + rSum, Math.max(ans, val));

        return val;
    }
}