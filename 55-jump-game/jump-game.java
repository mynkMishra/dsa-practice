class Solution {

    int[] dp;
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(0, nums);
    }

    public boolean solve(int idx, int[] nums){

        if(idx == nums.length){
            return false;
        }

        if(idx == nums.length - 1){
            return true;
        }

        if(dp[idx] != -1){
            return dp[idx] == 1;
        }

        boolean ans = false;
        for(int i = 1; i <= nums[idx]; i++){
            ans = ans || solve(idx + i, nums);
        }
        dp[idx] = ans ? 1 : 0;

        return dp[idx] == 1;
    }
}