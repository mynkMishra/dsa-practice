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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    public int getJustSmaller(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node.val;
    }

    public int getJustLarger(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }

    public TreeNode delete(TreeNode node, int key){
        if(node == null){
            return null;
        }
        if(node.val == key){
            if(node.left == null && node.right == null){
                return null;
            }else if(node.right == null){
                node.val = getJustSmaller(node.left);
                key = node.val;
            }else{
                node.val = getJustLarger(node.right);
                key = node.val;
            }
        }
        if(node.val <= key){
            node.right = delete(node.right, key);
        }

        if(node.val >= key){
            node.left = delete(node.left, key);
        }

        return node;
    }
}