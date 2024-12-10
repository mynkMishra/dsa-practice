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

    TreeNode pre;
    Map<Integer, TreeNode> hmRoot;
    Map<Integer, TreeNode> hmLeaf;
    int preCount = 0;
    int postCount = 0;
    public TreeNode canMerge(List<TreeNode> trees) {
        hmRoot = new HashMap<Integer, TreeNode>();
        hmLeaf = new HashMap<Integer, TreeNode>();

        for(TreeNode root : trees){
            hmRoot.put(root.val, root);
        }

        for(TreeNode root: trees){
            if(root.left != null || root.right != null){
                dfs(root);
            }else{
                preCount++;
            }
        }

        for(Integer leafVal: hmLeaf.keySet()){
            if(hmRoot.get(leafVal) != null){
                hmLeaf.get(leafVal).left = hmRoot.get(leafVal).left;
                hmLeaf.get(leafVal).right = hmRoot.get(leafVal).right;
                hmRoot.remove(leafVal);
                preCount--;
            }
        }

        TreeNode ans = null;

        if(hmRoot.size() > 1){
            return null;
        }

        for(Integer k: hmRoot.keySet()){
            ans = hmRoot.get(k);
        }

        traverse(ans);
        if(!isBst(ans) || preCount != postCount){
            return null;
        }

        // System.out.println(preCount + " " + postCount);

        return ans;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            hmLeaf.put(root.val, root);
        }

        dfs(root.left);
        preCount++;
        dfs(root.right);
    }

    public void traverse(TreeNode node){

        if(node == null){
            return;
        }

        traverse(node.left);
        postCount++;
        traverse(node.right);
    }

    public boolean isBst(TreeNode node){
        if(node == null){
            return true;
        }

        boolean isL = isBst(node.left);
        if(pre != null && pre.val >= node.val){
            return false;
        }
        
        pre = node;
        boolean isR = isBst(node.right);

        return isL && isR;
    }
}