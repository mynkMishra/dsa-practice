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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        boolean flag = false;

        while(queue.size() > 0){
            int size = queue.size();
            LinkedList<TreeNode> q = new LinkedList<TreeNode>();

            List<Integer> l = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                if(!flag){
                   TreeNode node = queue.removeFirst();
                    l.add(node.val);

                    if(node.left != null){
                        q.addFirst(node.left);
                    }

                    if(node.right != null){
                        q.addFirst(node.right);
                    }
                   
                }else{
                   TreeNode node = queue.removeFirst();
                   l.add(node.val);

                   if(node.right != null){
                        q.addFirst(node.right);
                   }

                    if(node.left != null){
                        q.addFirst(node.left);
                    }
                   
                   
                }
            }

            queue = q;
            ans.add(l);
            flag = !flag;
        }

        return ans;
    }
}