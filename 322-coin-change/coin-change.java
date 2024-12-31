class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);

        int ans = dp(amount, coins, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int dp(int amount, int[] coins, int[] memo){
        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        if(memo[amount] != -1){
            return memo[amount];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int count = dp(amount - coins[i], coins, memo);
            ans = Math.min(ans, count);
        }

        return memo[amount] = ans == Integer.MAX_VALUE ? Integer.MAX_VALUE : ans + 1;
    }
}