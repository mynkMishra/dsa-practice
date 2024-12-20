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
    public TreeNode reverseOddLevels(TreeNode root) {
        
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        
        while(queue.size() > 0){
            // System.out.println(level + " " + queue.size());
            if(level%2 == 0){
                int size = queue.size();
                ArrayList<TreeNode> list = new ArrayList<TreeNode>();
                for(int i = 0; i < size; i++){
                    list.add(queue.removeFirst());
                }

                int N = list.size();
                int i = 0;
                if(N == 1){
                    TreeNode l = root.left;
                    TreeNode r = root.right;

                    root.left = r;
                    root.right = l;
                }else{
                    while(i < list.size()/2){
                        TreeNode l = list.get(i);
                        TreeNode r = list.get(N - i - 1);

                        TreeNode tl = l.left;
                        TreeNode tr = l.right;

                        l.left = r.right;
                        l.right = r.left;

                        r.left = tr;
                        r.right = tl;

                        i++;
                    }
                }

                i = 0;
                while(i < list.size()){
                    if(list.get(i).left != null){
                        queue.addLast(list.get(i).left);
                    }
                    
                    if(list.get(i).right != null){
                        queue.addLast(list.get(i).right);
                    }
                    
                    i++;
                }
                level++;
            }else{
                int size = queue.size();
                ArrayList<TreeNode> list = new ArrayList<TreeNode>();
                for(int i = 0; i < size; i++){
                    list.add(queue.removeFirst());
                }

                int N = list.size();
                int i = 0;
                
                while(i < list.size()/2){
                    TreeNode nodeA = list.get(i);
                    TreeNode nodeB = list.get(N - i - 1);

                    TreeNode lA = nodeA.left;
                    TreeNode rA = nodeA.right;

                    TreeNode lB = nodeB.left;
                    TreeNode rB = nodeB.right;

                    nodeA.left = lB;
                    nodeA.right = rB;

                    nodeB.left = lA;
                    nodeB.right = rA;
                   
                    i++;
                }

                i = 0;
                while(i < list.size()){
                    if(list.get(i).left != null){
                        queue.addLast(list.get(i).left);
                    }
                    
                    if(list.get(i).right != null){
                        queue.addLast(list.get(i).right);
                    }
                    
                    i++;
                }
                level++;
            }
        }

        return root;
    }
}