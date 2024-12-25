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
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        int lvl = 0;

        while(queue.size() > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();

                if(lvl + 1 == ans.size()){
                    ans.set(lvl, Math.max(ans.get(lvl), node.val));
                }else{
                    ans.add(node.val);
                }

                if(node.left != null){
                    queue.addLast(node.left);
                }

                if(node.right != null){
                    queue.addLast(node.right);
                }
            }

            lvl++;
        }

        return ans;
    }
}