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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        dfs(root1, l1);

        ArrayList<Integer> l2 = new ArrayList<Integer>();
        dfs(root2, l2);

        ArrayList<Integer> l3 = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        while(i < l1.size() && j < l2.size()){
            if(l1.get(i) < l2.get(j)){
                l3.add(l1.get(i));
                i++;
            }else{
                l3.add(l2.get(j));
                j++;
            }
        }

        while(i < l1.size()){
            l3.add(l1.get(i));
            i++;
        }

        while(j < l2.size()){
            l3.add(l2.get(j));
            j++;
        }

        return l3;
    }

    public void dfs(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}