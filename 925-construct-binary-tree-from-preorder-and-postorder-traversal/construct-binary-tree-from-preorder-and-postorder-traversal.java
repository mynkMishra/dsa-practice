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

    class El{
        int idx;
        TreeNode node;

        El(int i, TreeNode n){
            idx = i;
            node = n;
        }
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Stack<El> stack = new Stack<El>();

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < postorder.length; i++){
            hm.put(postorder[i], i);
        }

        TreeNode root = null;

        for(int i = 0; i < preorder.length; i++){
            int v = preorder[i];
            TreeNode node = new TreeNode(v);

            while(stack.size() > 0 && hm.get(v) >= stack.peek().idx){
                stack.pop();
            }

            if(stack.size() == 0){
                if(root == null){
                    root = node;
                }
                stack.add(new El(hm.get(v), node));
            }else{
                if(stack.peek().node.left == null){
                    stack.peek().node.left = node;
                }else{
                    stack.peek().node.right = node;
                }
                stack.add(new El(hm.get(v), node));
            }
        }

        return root;
    }
}