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
    class Node{
        TreeNode val;
        int x;
        int y;

        Node(TreeNode val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    Map<Integer, List<List<Integer>>> map = new TreeMap<Integer, List<List<Integer>>>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        bfs(root);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i = 0;
        for(Integer k: map.keySet()){
            if(map.get(i) == null){
                result.add(new ArrayList<Integer>());
            }
            List<List<Integer>> l = map.get(k);
            for(List<Integer> r: l){
                Collections.sort(r);
                for(int t: r){
                    if(result.size() < i + 1){
                        result.add(new ArrayList<Integer>());
                    }
                    result.get(i).add(t);
                }
            }
            i++;
        }

        return result;
    }

    public void bfs(TreeNode node){
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(new Node(node, 0, 0));

        while(queue.size() > 0){
            int size = queue.size();

            while(size > 0){
                Node el = queue.removeFirst();

                if(map.get(el.y) == null){
                    map.put(el.y, new ArrayList<List<Integer>>());
                }
                while(map.get(el.y).size() < el.x + 1){
                    map.get(el.y).add(new ArrayList<Integer>());
                }
                // if(map.get(el.y).size() < el.x + 1){
                //     map.get(el.y).add(new ArrayList<Integer>());
                // }
                map.get(el.y).add(new ArrayList<Integer>());
                // System.out.println(el.y + " " + el.x + " " + map.get(el.y).size());
                map.get(el.y).get(el.x).add(el.val.val);
                if(el.val.left != null){
                    queue.addLast(new Node(el.val.left, el.x + 1, el.y - 1));
                }
                
                if(el.val.right != null){
                    queue.addLast(new Node(el.val.right, el.x + 1, el.y + 1));
                }
                
                size--;
            }
        }
    }
}