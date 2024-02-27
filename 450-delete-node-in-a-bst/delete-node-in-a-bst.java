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
    public TreeNode deleteNode(TreeNode root, int key) {
        inorderTraversal(root);
        return construct(0, inorder.size() - 1, key);
    }

    public void inorderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        inorder.add(node.val);
        inorderTraversal(node.right);
    }

    public TreeNode construct(int start, int end, int key){

        if(start > end){
            return null;
        }

        int mid = (start + end)/2;
        if(inorder.get(mid) == key){
            if(mid == end){
                return null;
            }
           mid++;
        }

        System.out.println(start + " " + end);
        TreeNode node = new TreeNode(inorder.get(mid));
        node.left = construct(start, mid - 1, key);
        node.right = construct(mid + 1, end, key);

        return node;
    }
}