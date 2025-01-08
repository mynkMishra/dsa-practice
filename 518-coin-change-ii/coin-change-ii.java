class Solution {
    
    public int change(int amount, int[] coins) {

        int[][] dp = new int[amount + 1][coins.length + 1];
        for(int j = 0; j <= coins.length; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i <= amount; i++){
            for(int j = 1; j <= coins.length; j++){
                dp[i][j] = dp[i][j - 1];
                if(i >= coins[j - 1]){
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }
        }

        return dp[amount][coins.length];
    }

    public int dp(int amount, int index, int[] coins){
        if(amount == 0){
            return 1;
        }

        if(amount < 0){
            return 0;
        }

        if(index < 0){
            return 0;
        }

        int ways1 = dp(amount - coins[index], index, coins);
        int ways2 = dp(amount, index - 1, coins);

        return ways1 + ways2;
    }
}