/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        dfs(root, sb);

        return sb.toString();
    }

    public void dfs(TreeNode node, StringBuilder sb){

        if(node == null){
            sb.append(Integer.MIN_VALUE + " ");
            return;
        }

        sb.append(node.val + " ");

        dfs(node.left, sb);

        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] val = data.split(" ");

        if(data.length() == 0){
            return null;
        }
        return makeTree(val);
    }

    public TreeNode makeTree(String[] nodeVal){

        int val = Integer.parseInt(nodeVal[idx]);
        if(val == Integer.MIN_VALUE){
            return null;
        }

        TreeNode node = new TreeNode(val);

        idx++;
        if(idx < nodeVal.length){
            node.left = makeTree(nodeVal);
        }

        idx++;
        if(idx < nodeVal.length){
            node.right = makeTree(nodeVal);
        }

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));