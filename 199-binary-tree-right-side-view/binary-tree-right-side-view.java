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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<ArrayList<Integer>> treeList = new ArrayList<ArrayList<Integer>>();

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);

        int lvl = 0;
        while(queue.size() > 0){
            int size = queue.size();
            if(treeList.size() < lvl + 1){
                treeList.add(new ArrayList<Integer>());
            }

            while(size > 0){
                TreeNode node = queue.removeFirst();
                if(node.left != null){
                    queue.addLast(node.left);
                }
                
                if(node.right != null){
                    queue.addLast(node.right);
                }
                
                treeList.get(lvl).add(node.val);
                size--;
            }
            lvl++;
        }

        List<Integer> result = new ArrayList<Integer>();
        for(ArrayList<Integer> l: treeList){
            result.add(l.get(l.size() - 1));
        }

        return result;
    }
}