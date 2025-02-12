class Solution {

    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            ans = Math.max(ans, solve(n - i)*i);
        }

        return ans;
    }

    public int solve(int n){

        if(dp[n] != -1){
            return dp[n];
        }
        
        int ans = n;
        for(int i = 1; i < n; i++){
            ans = Math.max(ans, solve(n - i)*i);
        }

        return dp[n] = ans;
    }
}