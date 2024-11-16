class Solution {

    List<Integer> list;
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<Integer>();
        ans = new ArrayList<List<Integer>>();

        // for(int i = 0; i < candidates.length; i++){
            solve(0, 0, candidates, target);
        // }

        return ans;
    }

    public void solve(int idx, int sum, int[] can, int target){

        if(idx == can.length || sum > target){
            return;
        }

        if(sum == target){
            ans.add(new ArrayList<Integer>(list));
            return;
        }


        for(int i = idx; i < can.length; i++){
            list.add(can[i]);
            solve(i, can[i] + sum, can, target);
            list.remove(list.size() - 1);
        }
    }
}