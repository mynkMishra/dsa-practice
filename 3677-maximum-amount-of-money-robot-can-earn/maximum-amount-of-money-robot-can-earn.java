class Solution {
    public int maximumAmount(int[][] coins) {

        int N = coins.length;
        int M = coins[0].length;

        int[][][] dp = new int[N][M][3];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }   
        }

        return solve(0, 0, 2, N, M, coins, dp);
    }

    public int solve(int i, int j, int rem, int N, int M, int[][] coins, int[][][] dp){

        if(i == N - 1 && j == M - 1){
            if(coins[i][j] < 0){
                return rem > 0 ? 0 : coins[i][j];
            }else{
                return coins[i][j];
            }
        }

         if(i >= N || j >= M){
            return -1000000;
        }

        if(dp[i][j][rem] != Integer.MIN_VALUE){
            return dp[i][j][rem];
        }

        int right = coins[i][j] + solve(i, j + 1, rem, N, M, coins, dp);
        int down = coins[i][j] + solve(i + 1, j, rem, N, M, coins, dp);

        if(coins[i][j] < 0 && rem > 0){
            right = Math.max(right, solve(i, j + 1, rem - 1, N, M, coins, dp));
            down = Math.max(down, solve(i + 1, j, rem - 1, N, M, coins, dp));
        }

        return dp[i][j][rem] = Math.max(right, down);
    }
}