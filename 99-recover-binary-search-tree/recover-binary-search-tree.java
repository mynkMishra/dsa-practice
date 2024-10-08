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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        // System.out.println(first.val + " " + second.val);
    }

    public void traverse(TreeNode node){

        if(node == null){
            return;
        }

        traverse(node.left);
        if(prev != null){
            if(prev.val > node.val){
                if(first == null){
                    first = prev;
                }

                if(first != null && first.val > node.val){
                    second = node;
                }
            }
        }
        prev = node;
        traverse(node.right);
    }
}