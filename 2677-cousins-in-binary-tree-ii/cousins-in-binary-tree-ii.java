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
    public TreeNode replaceValueInTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.addLast(root);
        while(queue.size() != 0){
            int len = queue.size();
            long sum = 0;
            List<TreeNode> parents = new ArrayList<TreeNode>();
            for(int i = 0; i < len; i++){
                TreeNode p = queue.removeFirst();
                parents.add(p);

                if(p.left != null){
                    sum += p.left.val;
                    queue.addLast(p.left);
                }

                if(p.right != null){
                    sum += p.right.val;
                    queue.addLast(p.right);
                }
            }

            for(TreeNode p: parents){
                TreeNode left = p.left;
                TreeNode right = p.right;

                long val = 0;
                if(left != null){
                    val += left.val;
                }

                if(right != null){
                    val += right.val;
                }

                if(left != null){
                    left.val = (int)(sum - val);
                }
                if(right != null){
                    right.val = (int)(sum - val);
                }
            }

        }

        root.val = 0;
        return root;
    }
}