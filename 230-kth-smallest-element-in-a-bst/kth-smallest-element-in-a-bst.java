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
    int k = -1;
    int result = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode node){

        if(node == null){
            return;
        }

        dfs(node.left);
        if(k == 1){
            result = node.val;
        }
        k--;
        dfs(node.right);
    }
}