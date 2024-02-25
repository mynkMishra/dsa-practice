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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return prepare(0, preorder.length - 1, 0, preorder.length - 1,preorder, inorder);
    }

    public TreeNode prepare(int start, int end, int pStart, int pEnd, int[] preorder, int[] inorder){

        if(pStart > pEnd || start > end){
            // System.out.println(pStart + " " + pEnd);
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = preorder[start];
        int ridx = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == node.val){
                ridx = i;
            }
        }

        int lEnd = start + (ridx - pStart);
        System.out.println(start + " " + end);
        node.left = prepare(start + 1, lEnd , pStart, ridx - 1, preorder, inorder);

        int rStart = end - (pEnd - ridx);
        node.right = prepare(rStart + 1, end, ridx + 1, pEnd, preorder, inorder);

        return node;
    }
}