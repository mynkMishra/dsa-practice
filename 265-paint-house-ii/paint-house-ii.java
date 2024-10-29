class Solution {

    int H;
    int C;
    int[][] dp;
    public int minCostII(int[][] costs) {
        
        H = costs.length;
        C = costs[0].length;
        dp = new int[H][C];

        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < C; i++){
            int x = costs[0][i];
            int cos = solve(1, i, costs);
            ans = Math.min(ans, cos + x);
        }

        return ans;
    }

    public int solve(int h, int c, int[][] costs){

        if(h == H){
            return 0;
        }

        if(dp[h][c] != -1){
            return dp[h][c];
        }

        int val = Integer.MAX_VALUE;
        for(int i = 0; i < C; i ++){
            if(i != c){
                int x = costs[h][i];
                int cos = solve(h + 1, i, costs);
                val = Math.min(val, cos + x);
            }
        }

        return dp[h][c] = val;
    }
}