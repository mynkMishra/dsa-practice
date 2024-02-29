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
    public boolean isEvenOddTree(TreeNode root) {
        return bfs(root);
    }

    public boolean bfs(TreeNode node){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(node);

        int lvl = 0;
        while(queue.size() > 0){
            int size = queue.size();
            int prev = lvl % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(size > 0){
                TreeNode el = queue.removeFirst();
                // System.out.println(size + " " + el.val + " " + prev);
                if(lvl % 2 == 0 && (prev >= el.val || el.val % 2 == 0)){
                    return false;
                }
                if(lvl % 2 != 0 && (prev <= el.val || el.val % 2 != 0)){
                    return false;
                }
                
                prev = el.val;

                if(el.left != null){
                    queue.addLast(el.left);
                }
                if(el.right != null){
                    queue.addLast(el.right);
                }
                size--;
            }
            lvl++;
        }

        return true;
    }
}