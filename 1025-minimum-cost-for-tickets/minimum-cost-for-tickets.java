class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int[][] memo = new int[days.length][366];

        for(int[] d: memo){
            Arrays.fill(d, -1);
        }
        return dp(0, 0, days, costs, memo);
    }

    public int dp(int currDay, int idx, int[] days, int[] costs, int[][] memo){

        if(idx == days.length || currDay > 365){
            return 0;
        }

        if(memo[idx][currDay] != -1){
            return memo[idx][currDay];
        }

        int op1 = currDay > days[idx] 
                    ? dp(currDay, idx + 1, days, costs, memo) 
                    : dp(days[idx] + 1, idx, days, costs, memo) + costs[0];
        
        int op2 = currDay > days[idx] 
                    ? dp(currDay, idx + 1, days, costs, memo) 
                    : dp(days[idx] + 7, idx, days, costs, memo) + costs[1];

        int op3 = currDay > days[idx] 
                    ? dp(currDay, idx + 1, days, costs, memo) 
                    : dp(days[idx] + 30, idx, days, costs, memo) + costs[2];
        
        return memo[idx][currDay] = Math.min(op1, Math.min(op2, op3));
    }
}