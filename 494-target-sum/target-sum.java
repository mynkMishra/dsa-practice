class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, 0, nums, target);
    }

    public int solve(int idx, int sum, int[] nums, int target){
        
        if(idx == nums.length){
            if(sum == target){
                return 1;
            }

            return 0;
        }
        int a = solve(idx + 1, sum + nums[idx], nums, target);
        int b = solve(idx + 1, sum - nums[idx], nums, target);

        return a + b;
    }
}