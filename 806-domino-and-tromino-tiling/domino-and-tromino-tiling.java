class Solution {

    long[][] dp;
    long mod = 1000000000 + 7;
    public int numTilings(int n) {
        dp = new long[n + 1][n + 1];

        for(long[] m: dp){
            Arrays.fill(m, -1);
        }
        return (int)(solve(n, n)%mod);
    }

    public long solve(int r1, int r2){

        if(r1 < 0 || r2 < 0){
            return 0;
        }

        if(r1 == 0 && r2 == 0){
            return 1;
        }

        if(dp[r1][r2] != -1){
            return dp[r1][r2];
        }

        long ans = 0;
        if(r1 > r2){
            ans += solve(r1 - 2, r2);
        }
        
        if(r1 == r2){
            ans += solve(r1 - 1, r2 - 1);
        }
        
        if(r1 < r2){
            ans += solve(r1, r2 - 2);
        }

        if(r1 == r2){
            ans += solve(r1 - 1, r2 - 2);
        }

        if(r1 - 1 == r2 - 2){
            ans += solve(r1 - 1, r2 - 2);
        }
        
        if(r1 == r2){
            ans += solve(r1 - 2, r2 - 1);
        }

        if(r1 - 2 == r2 - 1){
            ans += solve(r1 - 2, r2 - 1);
        }
        
        if(r1 == r2){
            ans += solve(r1 - 2, r2 - 2);
        }

        return dp[r1][r2] = ans%mod;
    }
}