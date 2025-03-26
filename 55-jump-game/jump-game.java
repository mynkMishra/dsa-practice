class Solution {

    int[] dp;
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int idx = 0;
        return run(0, nums);
    }

    public boolean run(int idx, int[] nums){
        if(idx == nums.length - 1){
            return true;
        }

        if(dp[idx] != -1){
            return dp[idx] == 1;
        }

        boolean isValid = false;
        for(int i = 1; i <= nums[idx]; i++){
            isValid = isValid || run(idx + i, nums);
            if(isValid){
                return true;
            }
        }

        dp[idx] = isValid ? 1 : 0;

        return isValid;
    }
}