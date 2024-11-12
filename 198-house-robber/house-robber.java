class Solution {

    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];

        dp[N - 1] = nums[N - 1];
        if(N == 1){
            return dp[0];
        }

        dp[N - 2] = Math.max(nums[N - 2], nums[N - 1]);   
        if(N == 2){
            return dp[0];
        }

        dp[N - 3] = Math.max(nums[N - 3] + dp[N - 1], nums[N - 2]);   
        if(N == 3){
            return dp[0];
        }

        for(int i = N - 3; i >= 0; i--){
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}