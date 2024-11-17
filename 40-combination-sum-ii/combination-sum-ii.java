class Solution {

    List<Integer> list;
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        list = new ArrayList<Integer>();
        ans = new ArrayList<List<Integer>>();

        solve(0, target, candidates);

        return ans;
    }

    public void solve(int idx, int target, int[] nums){

        if(target == 0){
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        if(target < 0){
            return;
        }

        if(idx == nums.length){
            return;
        }

        list.add(nums[idx]);
        solve(idx + 1, target - nums[idx], nums);

        list.remove(list.size() - 1);
        while(idx != nums.length - 1 && nums[idx] == nums[idx + 1]){
            idx++;
        }

        solve(idx + 1, target, nums);
    }
}