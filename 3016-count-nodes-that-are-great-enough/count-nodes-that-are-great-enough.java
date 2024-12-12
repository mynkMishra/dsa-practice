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

    class Result{
        int count;
        ArrayList<Integer> values;

        public Result(int count, ArrayList<Integer> values){
            this.count = count;
            this.values = values;
        }
    }

    int ans = 0;
    public int countGreatEnoughNodes(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }

    public Result traverse(TreeNode node, int k){

        if(node == null){
            return null;
        }

        Result lres = traverse(node.left, k);
        Result rres = traverse(node.right, k);

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(lres == null && rres == null){
            list.add(node.val);
            return new Result(1, list);
        }

        int p1 = 0;
        int p2 = 0;

        ArrayList<Integer> l1 = null;
        ArrayList<Integer> l2 = null;
        int smallerCount = 0;

        if(lres == null){
            l1 = new ArrayList<Integer>();
        }else{
            l1 = lres.values;
        }

        if(rres == null){
            l2 = new ArrayList<Integer>();
        }else{
            l2 = rres.values;
        }

        while(p1 < l1.size() && p2 < l2.size() && list.size() < k){
            if(l1.get(p1) < l2.get(p2)){
                int val = l1.get(p1);
                list.add(val);
                p1++; 
            }else{
                int val = l2.get(p2);
                list.add(val);
                p2++;
            }
        }

        while(p1 < l1.size() && list.size() < k){
            int val = l1.get(p1);
            list.add(val);
            p1++;
        }

        while(p2 < l2.size() && list.size() < k){
            int val = l2.get(p2);
            list.add(val);
            p2++;   
        }

        ArrayList<Integer> t = new ArrayList<Integer>();

        int j = 0;
        while(j < list.size() && list.get(j) < node.val && t.size() < k){
            t.add(list.get(j));
            j++;
        }

        int lcnt = lres == null ? 0 : lres.count;
        int rcnt = rres == null ? 0 : rres.count;
        if(t.size() >= k && lcnt + rcnt >= k){
            ans++;
        }

        if(t.size() < k){
            t.add(node.val);
        }

        if(t.size() < k){
            while(j < list.size() && t.size() < k){
                t.add(list.get(j));
                j++;
            }
        }
        
        return new Result(lcnt + rcnt + 1, t);
    }
}