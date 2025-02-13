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

    int dia = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);

        return dia;
    }

    public int solve(TreeNode node){

        if(node == null){
            return 0;
        }

        int dl = solve(node.left);
        int dr = solve(node.right);
        dia = Math.max(dia, dl + dr);

        return Math.max(dl, dr) + 1;
    }
}