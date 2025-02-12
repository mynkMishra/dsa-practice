class Solution {

    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 1;
        dp[0] = 0;

        int res = Integer.MIN_VALUE;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], Math.max(dp[i - j], i - j)*j);
            }
        }

        return dp[n];
    }
}