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

    int mod = 1000_000_000 + 7;
    public int pathSum(TreeNode root, int targetSum) {
        
        return solve(root, targetSum);
    }

    public int solve(TreeNode node, int targetSum){

        if(node == null){
            return 0;
        }

        int lCount = getCount(node, 0, targetSum);

        int ls = solve(node.left, targetSum);

        int rs = solve(node.right, targetSum);

        return lCount + ls + rs;
    }

    public int getCount(TreeNode node, int sum, int targetSum){

        if(node == null){
            return 0;
        }

        int lc = getCount(node.left, (sum + node.val)%mod, targetSum);

        int rc = getCount(node.right, (sum + node.val)%mod, targetSum);

        if(sum + node.val == targetSum){
            return lc + rc + 1;
        }
        return lc + rc;
    }
}