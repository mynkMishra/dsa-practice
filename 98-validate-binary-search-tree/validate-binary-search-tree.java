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
    ArrayList<Integer> inorder = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        traverse(root);
        for(int i = 1; i < inorder.size() ; i++){
            if(inorder.get(i - 1) >= inorder.get(i)){
                return false;
            }
            // System.out.print(inorder.get(i) + " ");
        }
        return true;
    }

    public void traverse(TreeNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        inorder.add(node.val);
        traverse(node.right);
    }
}