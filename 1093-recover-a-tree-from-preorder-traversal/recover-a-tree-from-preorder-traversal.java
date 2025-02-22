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

    class El{
        int D;
        TreeNode node;

        public El(int d, TreeNode n){
            D = d;
            node = n;
        }
    }

    public TreeNode recoverFromPreorder(String traversal) {
        LinkedList<El> stack = new LinkedList<El>();
        TreeNode root = null;
        int i = 0;
        while(i < traversal.length()){
            
            int count = 0;

            while(i < traversal.length() && traversal.charAt(i) == '-'){
                count++;
                i++;
            }

            int l = i;
            int r = i;

            while(r < traversal.length() && traversal.charAt(r) != '-'){
                r++;
            }
            
            int nodeVal = Integer.parseInt(traversal.substring(l, r));
            i = r;

            while(stack.size() > 0 && stack.peekLast().D >= count){
                stack.removeLast();
            }

            TreeNode child = new TreeNode(nodeVal);
            El el = new El(count, child);
            if(root == null){
                root = child;
            }

            if(stack.size() == 0){
                stack.addLast(el);
            }else{
                TreeNode parent = stack.peekLast().node;

                if(parent.left == null){
                    parent.left = child;
                }else{
                    parent.right = child;
                }

                stack.addLast(el);
            }
        }

        return root;
    }
}