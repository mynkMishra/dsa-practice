class Solution {

    int[][][] dp;
    public int longestPalindromicSubsequence(String s, int k) {
        dp = new int[s.length() + 1][s.length() + 1][k + 1];

        for(int[][] d: dp){
            for(int[] p: d){
                Arrays.fill(p, -1);
            }
        }

        return solve(0, s.length() - 1, k, s);
    }

    public int solve(int i, int j, int k, String s){

        if(i > j){
            return 0;
        }

        if(i == j){
            return 1;
        }

        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }

        int ans = 0;
        if(s.charAt(i) == s.charAt(j)){
            ans = solve(i + 1, j - 1, k, s) + 2;
        }else{

            ans = Math.max(solve(i + 1, j, k, s), solve(i, j - 1, k, s));

            int diff = getDiff(s.charAt(i), s.charAt(j));
            if(k >= diff){
                ans = Math.max(ans, solve(i + 1, j - 1, k - diff, s) + 2);
            }
        }

        return dp[i][j][k] = ans;
    }

    public int getDiff(char ch1, char ch2){
        int d = Math.abs(ch1 - ch2);
        return Math.min(d, 26 - d);
    }
}