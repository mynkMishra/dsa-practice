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
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }

    public List<TreeNode> solve(int l, int r){

        if(l > r){
            List<TreeNode> tree = new ArrayList<TreeNode>();
            tree.add(null);
            return tree;
        }

        if(l == r){
            List<TreeNode> tree = new ArrayList<TreeNode>();
            tree.add(new TreeNode(l));
            return tree;
        }

        List<TreeNode> tree = new ArrayList<TreeNode>();

        for(int i = l; i <= r; i++){
            
            List<TreeNode> left = solve(l, i - 1);
            List<TreeNode> right = solve(i + 1, r);

            for(TreeNode lt: left){
                for(TreeNode rt: right){
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    tree.add(root);
                }
            }
            
        }

        return tree;
    }
}