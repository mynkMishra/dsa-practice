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

    int maxDepth = -1;
    Map<Integer, List<TreeNode>> hm = new HashMap<Integer, List<TreeNode>>();
    TreeNode ans = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
        dfs(root, 0);

        if(hm.get(maxDepth).size() == 1){
            return hm.get(maxDepth).get(0);
        }

        Set<TreeNode> hs = new HashSet<>();
        for(TreeNode n: hm.get(maxDepth)){
            hs.add(n);
        }

        System.out.println(hs.size());
        findLca(root, hs);

        return ans;
    }

    public int findLca(TreeNode root, Set<TreeNode> hs){

        if(root == null){
            return 0;
        }

        int ls = findLca(root.left, hs);
        int rs = findLca(root.right, hs);

        if(ls + rs + hs.size() == 0 && ans == null){
            ans = root;
        }

        if(hs.contains(root)){
            return ls + rs - 1; 
        }

        return ls + rs;
    }

    public void dfs(TreeNode node, int depth){

        if(node == null){
            return;
        }

        if(!hm.containsKey(depth)){
            hm.put(depth, new ArrayList<TreeNode>());
        }
        hm.get(depth).add(node);
        maxDepth = Math.max(maxDepth, depth);

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}