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
class FindElements {

    HashSet<Integer> hs;
    public FindElements(TreeNode root) {
        hs = new HashSet<Integer>();

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        root.val = 0;
        stack.addLast(root);

        while(stack.size() > 0){
            TreeNode node = stack.removeLast();
            hs.add(node.val);

            if(node.left != null){
                node.left.val = 2*node.val + 1;
                stack.addLast(node.left);
            }

            if(node.right != null){
                node.right.val = 2*node.val + 2;
                stack.addLast(node.right);
            }
        }
    }
    
    public boolean find(int target) {
        return hs.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */