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

    double diff1 = Double.MIN_VALUE;
    double diff2 = Double.MIN_VALUE;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        traverse(root, stack, target, k);

        List<Integer> list = new ArrayList<Integer>();

        while(stack.size() > 0){
            list.add(stack.removeLast().val);
        }

        return list;
    }

    public void traverse(TreeNode root, LinkedList<TreeNode> stack, double target, int k){

        if(root == null){
            return;
        }

        traverse(root.left, stack, target, k);

        if(stack.size() < k){
            if(diff1 == Double.MIN_VALUE){
                diff1 = Math.abs(root.val*1.0 - target);
            }else{
                diff2 = Math.abs(root.val*1.0 - target);
            }
            stack.addFirst(root);
        }else{

            if((double)Math.abs(root.val*1.0 - target) <= diff1 || (double)Math.abs(root.val*1.0 - target) <= diff2){
                stack.removeLast();
                stack.addFirst(root);

                diff1 = Math.abs(stack.peekLast().val*1.0 - target);
                diff2 = Math.abs(stack.peekFirst().val*1.0 - target);
            }
        }
        

        traverse(root.right, stack, target, k);
    }
}