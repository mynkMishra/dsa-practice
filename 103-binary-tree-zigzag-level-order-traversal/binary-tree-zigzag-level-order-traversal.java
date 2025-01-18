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
        int lvl = 0;
        queue.addLast(root);

        while(queue.size() > 0){
            List<Integer> l = new ArrayList<Integer>();
            
            int size = queue.size();

            while(size > 0){
                TreeNode el = queue.removeFirst();
                l.add(el.val);

                if(lvl%2 == 0){
                    if(el.left != null){
                        queue.addLast(el.left);
                    }
                    
                    if(el.right != null){
                        queue.addLast(el.right);
                    }
                    
                }else{

                    if(el.right != null){
                        queue.addLast(el.right);
                    }
                    
                     if(el.left != null){
                        queue.addLast(el.left);
                    }
                    
                }
                size--;
            }

            ans.add(l);
            
            LinkedList<TreeNode> aux = new LinkedList<TreeNode>();
            while(queue.size() > 0){
                aux.addLast(queue.removeLast());
            }

            queue = aux;
            lvl++;
        }

        return ans;
    }
}