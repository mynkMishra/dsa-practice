class Solution {

    long mod = 1000000000 + 7;
    public int countHousePlacements(int n) {

        long[] memo = new long[n + 1];

        Arrays.fill(memo, -1);
        long ans = dp(0, n, memo);
        
        return (int)((ans*ans)%mod);
    }

    public long dp(int street, int n, long[] memo){
        if(street >= n){
            return 1;
        }

        if(memo[street] != -1){
            return memo[street];
        }

        long ans = dp(street + 2, n, memo)%mod + dp(street + 1, n, memo)%mod;
        return memo[street] = ans;
    }
}