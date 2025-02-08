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

    Set<Integer> deleteHm;
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        deleteHm = new HashSet<Integer>();
        ans = new ArrayList<TreeNode>();

        for(int el: to_delete){
            deleteHm.add(el);
        }

        solve(root, deleteHm);

        boolean isDeleted = deleteHm.contains(root.val);

        if(isDeleted){
            if(root.left != null){
                ans.add(root.left);
                root.left = null;
            }

            if(root.right != null){
                ans.add(root.right);
                root.right = null;
            }     
        }else{
            ans.add(root);
        }

        return ans;
    }

    public TreeNode solve(TreeNode root, Set<Integer> deleteHm){
        if(root == null){
            return null;
        }

        boolean isDeleted = deleteHm.contains(root.val);

        root.left = solve(root.left, deleteHm);
        root.right = solve(root.right, deleteHm);

        if(isDeleted){
            if(root.left != null){
                ans.add(root.left);
                root.left = null;
            }

            if(root.right != null){
                ans.add(root.right);
                root.right = null;
            }   

            return null;         
        }

        return root;
    }
}