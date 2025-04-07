class Solution {

    int[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        dp = new int[nums.length + 1][100000];

        for(int[] a: dp){
            Arrays.fill(a, -1);
        }

        for(int el: nums){
            sum += el;
        }

        if(sum%2 != 0){
            return false;
        }

        return solve(0, sum/2, nums);
    }

    public boolean solve(int idx, int sum, int[] nums){

        if(sum == 0){
            return true;
        }

        if(sum < 0 || idx >= nums.length){
            return false;
        }

        if(dp[idx][sum] != -1){
            return dp[idx][sum] == 1;
        }

        boolean taken = solve(idx + 1, sum - nums[idx], nums);

        boolean skip = solve(idx + 1, sum, nums);

        dp[idx][sum] = (taken || skip) ? 1 : 0;

        return taken || skip;
    }
}