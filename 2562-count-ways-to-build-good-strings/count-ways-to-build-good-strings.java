class Solution {

    long mod = 1000000000 + 7;
    public int countGoodStrings(int low, int high, int zero, int one) {

        long[] memo = new long[high + 1];
        Arrays.fill(memo, -1);

        dp(0, low, high, zero, one, memo);

        return (int)(memo[0]%mod);
    }

    public long dp(int len, int low, int high, int zero, int one, long[] memo){

        if(len > high){
            return 0L;
        }

        if(memo[len] != -1){
            return memo[len];
        }

        long op1 = dp(len + zero, low, high, zero, one, memo);
        long op2 = dp(len + one, low, high, zero, one, memo);

        long op = (long)((long)op1 + (long)op2);
        return memo[len] = len >= low ? (long)(op + 1L)%mod : op%mod;
    }
}