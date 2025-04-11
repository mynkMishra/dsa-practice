class Solution {

    int[] dp;
    long mod = 1000_000_000 + 7;
    public int numberOfArrays(String s, int k) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        return solve(0, s, k);
    }

    public int solve(int idx, String s, int k){
        
        if(idx >= s.length()){
            return 1;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        long count = 0;
        for(int i = idx + 1; i <= Math.min(idx + 10, s.length()); i++){
            String str = s.substring(idx, i);
            if(noLeadingZero(str) && isValidInt(str) && Integer.parseInt(str) <= k){
                count += solve(i, s, k);
            }
        }

        return dp[idx] = (int)(count%mod);
    }

    public boolean isValidInt(String s){
        Long l = Long.parseLong(s);
        return l.compareTo((long)Integer.MAX_VALUE) < 0;
    }

    public boolean noLeadingZero(String str){
        return str.charAt(0) != '0';
    }
}