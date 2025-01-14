class Solution {

    int[][] memo;
    public int maxProfit(int[] prices) {
        memo = new int[prices.length + 1][prices.length + 2];
        
        for(int[] m: memo){
            Arrays.fill(m, -1);
        }
        return Math.max(solve(0, 0, prices), solve(0, -1, prices));
    }

    public int solve(int idx, int buyDay, int[] prices){

        if(idx == prices.length){
            return 0;
        }

        if(memo[idx][buyDay + 1] != -1){
            return memo[idx][buyDay + 1];
        }

        int a1 = Integer.MIN_VALUE;
        if(buyDay == -1){
            a1 = solve(idx + 1, idx + 1, prices);
        }

        int a2 = Integer.MIN_VALUE;
        if(buyDay != -1){
            int profit = prices[idx] - prices[buyDay];
            a2 = solve(idx + 1, -1, prices) + profit;
        }

        int a3 = solve(idx + 1, buyDay, prices);

        return memo[idx][buyDay + 1] = Math.max(a1, Math.max(a2, a3));
    }
}