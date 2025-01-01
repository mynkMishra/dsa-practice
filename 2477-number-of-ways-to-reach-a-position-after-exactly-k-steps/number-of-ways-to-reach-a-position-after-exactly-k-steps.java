class Solution {
    
    long mod = 1000000000 + 7;

    public int numberOfWays(int startPos, int endPos, int k) {
        long[][] memo = new long[4*1000 + 1][4*1000 + 1];

        for(long[] m: memo){
            Arrays.fill(m, -1);
        }

        return (int)(dp(startPos, endPos, k, memo)%mod);
    }

    public long dp(int start, int end, int k, long[][] memo){

        if(k < 0){
            return 0;
        }

        if(k == 0){
            if(start == end){
                return 1;
            }
            return 0;
        }

        if(memo[start + 2*1000][k + 2*1000] != -1){
            return memo[start + 2*1000][k + 2*1000];
        }

        long ways1 = dp(start + 1, end, k - 1, memo);
        long ways2 = dp(start - 1, end, k - 1, memo);

        return memo[start + 2*1000][k + 2*1000] = (ways1 + ways2)%mod;
    }
}