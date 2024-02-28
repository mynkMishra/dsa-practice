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
    int maxLvl = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return map.get(maxLvl);
    }

    public void dfs(TreeNode node, int lvl){
        if(node == null){
            return;
        }

        maxLvl = Math.max(maxLvl, lvl);
        if(map.get(lvl) == null){
            map.put(lvl, node.val);
        }
        dfs(node.left, lvl + 1);
        dfs(node.right, lvl + 1);
    }
}