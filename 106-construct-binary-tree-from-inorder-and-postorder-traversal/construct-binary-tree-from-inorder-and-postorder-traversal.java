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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return contruct(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }

    public TreeNode contruct(int iStart, int iEnd, int pStart, int pEnd, int[] inorder, int[] postorder){

        if(pStart > pEnd){
            return null;
        }

        TreeNode node = new TreeNode(postorder[pEnd]);

        int idx = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == postorder[pEnd]){
                idx = i;
            }
        }

        int leftEl = idx - iStart;
        int rightEl = iEnd - idx;

        node.left = contruct(iStart, idx - 1, pStart, pStart + leftEl - 1, inorder, postorder);
        node.right = contruct(idx + 1, iEnd, pEnd - rightEl, pEnd - 1, inorder, postorder);

        return node;
    }
}