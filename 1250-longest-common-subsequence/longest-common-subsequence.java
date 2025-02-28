class Solution {

    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];

        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        solve(0, 0, text1, text2);

        int ans = -1;

        for(int i = 0; i < text1.length(); i++){
            for(int j = 0; j < text2.length(); j++){
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    public int solve(int i, int j, String text1, String text2){

        if(i >= text1.length() || j >= text2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = solve(i + 1, j + 1, text1, text2) + 1;
        }else{
            return dp[i][j] = Math.max(solve(i, j + 1, text1, text2), solve(i + 1, j, text1, text2));
        }
    }
}