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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        List<Long> list = new ArrayList<Long>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.addLast(root);

        while(queue.size() != 0){
            int len = queue.size();
            long sum = 0;
            for(int i = 0; i < len; i++){
                TreeNode node = queue.removeFirst();
                sum += (long)node.val;

                if(node.left != null){
                    queue.addLast(node.left);
                }
                
                if(node.right != null){
                    queue.addLast(node.right);
                } 
            }

            list.add(sum);
            
        }

        if(list.size() < k){
            return -1;
        }

        list.sort(Collections.reverseOrder());
        return list.get(k - 1);
        
    }
}