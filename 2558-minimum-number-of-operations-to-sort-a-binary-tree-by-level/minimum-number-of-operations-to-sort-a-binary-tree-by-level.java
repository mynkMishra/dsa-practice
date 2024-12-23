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
    public int minimumOperations(TreeNode root) {
        
        int ans = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.addLast(root);

        while(queue.size() > 0){

            int size = queue.size();
            ArrayList<Integer> l = new ArrayList<Integer>();

            while(size > 0){
                TreeNode node = queue.removeFirst();

                if(node.left != null){
                    l.add(node.left.val);
                    queue.addLast(node.left);
                }

                if(node.right != null){
                    l.add(node.right.val);
                    queue.addLast(node.right);
                }
                
                size--;
            }

            int[] arr = new int[l.size()];
            for(int i = 0; i < l.size(); i++){
                arr[i] = l.get(i);
            }

            ans += getSwapCount(arr);
        }

        return ans;
    }

    public int getSwapCount(int[] arr){

        int[] sorted = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            sorted[i] = arr[i];
        }

        Arrays.sort(sorted);
        Map<Integer, Integer> sortedMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++){
            sortedMap.put(sorted[i], i);
        }

        Map<Integer, Integer> graph = new HashMap<Integer, Integer>();
        boolean[] visited = new boolean[arr.length];

        for(int i = 0; i < arr.length; i++){
            graph.put(i, sortedMap.get(arr[i]));
        }

        int swaps = 0;
        for(int i = 0; i < arr.length; i++){

            if(visited[i] || graph.get(i) == i){
                continue;
            }

            int cycle_size = 0;
            int j = i;
            while(!visited[j]){
                visited[j] = true;
                j = graph.get(j);
                cycle_size++;
            }

            swaps += (cycle_size - 1);
        }

        return swaps;
    }
}