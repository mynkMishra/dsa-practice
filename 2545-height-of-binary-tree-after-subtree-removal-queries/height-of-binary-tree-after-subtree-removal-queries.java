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

    int currentMaxHeight = 0;
    int[] heightAfterRemoval = new int[100001];
    public int[] treeQueries(TreeNode root, int[] queries) {
        traverseLeftToRight(root, 0);
        currentMaxHeight = 0;
        traverseRightToLeft(root, 0);

        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            ans[i] = heightAfterRemoval[queries[i]];
        }

        return ans;
    }

    public void traverseRightToLeft(TreeNode root, int currHeight){
        if(root == null) return;

        heightAfterRemoval[root.val] = Math.max(
            heightAfterRemoval[root.val],
            currentMaxHeight
        );

        currentMaxHeight = Math.max(currHeight, currentMaxHeight);

        traverseRightToLeft(root.right, currHeight + 1);
        traverseRightToLeft(root.left, currHeight + 1);
    }

    public void traverseLeftToRight(TreeNode root, int currHeight){
        if(root == null) return;

        heightAfterRemoval[root.val] = currentMaxHeight;

        currentMaxHeight = Math.max(currHeight, currentMaxHeight);

        traverseLeftToRight(root.left, currHeight + 1);
        traverseLeftToRight(root.right, currHeight + 1);
    }
}