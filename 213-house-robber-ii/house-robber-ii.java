class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N == 1){
            return nums[0];
        }
        if(N == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] nums1 = new int[N - 1];
        int[] nums2 = new int[N - 1];

        for(int i = 0; i < N - 1; i++){
            nums1[i] = nums[i];
        }

        for(int i = 1; i < N; i++){
            nums2[i - 1] = nums[i];
        }

        int L = nums1.length;
        int[] dp1 = solve(nums1);
        int[] dp2 = solve(nums2);

        return Math.max(dp1[0], dp2[0]);
    }

    public int[] solve(int[] nums){
        int N = nums.length;
        int[] dp = new int[N];

        dp[N - 1] = nums[N - 1];
        if(N == 1){
            return dp;
        }

        dp[N - 2] = Math.max(nums[N - 2], nums[N - 1]);
        if(N == 2){
            return dp;
        }

        for(int i = N - 3; i >= 0; i--){
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp;
    }
}