class Solution {

    int[][] dp;
    int tripCost = Integer.MAX_VALUE;
    public int mincostTickets(int[] days, int[] costs) {
        int N = days.length;
        dp = new int[N][366];

        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        
        tripCost = solve(0, 0, days, costs);
        return tripCost;
    }

    public int solve(int idx, int nextDay, int[] days, int[] costs){

        if(idx >= days.length || nextDay > 365){
            return 0;
        }

        if(dp[idx][nextDay] != -1){
            return dp[idx][nextDay];
        }

        int amount = 0;

        if(days[idx] >= nextDay){
            // include
            int day = solve(idx + 1, days[idx] + 1, days, costs) + costs[0];

            int week = solve(idx + 1, days[idx] + 7, days, costs) + costs[1];

            int month = solve(idx + 1, days[idx] + 30, days, costs) + costs[2];

            amount = Math.min(day, Math.min(week, month));
        }else{
            // exclude
            amount = solve(idx + 1, nextDay, days, costs);
        }

        return dp[idx][nextDay] = amount;
    }
}