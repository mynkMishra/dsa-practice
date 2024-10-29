class Solution {

    int ans = Integer.MIN_VALUE;
    int[][] dp;
    public int maxMoves(int[][] grid) {
        
        int R = grid.length;
        int C = grid[0].length;
        dp = new int[R][C];

        for(int[] d: dp){
            Arrays.fill(d, - 1);
        }

        for(int i = 0; i < R; i++ ){
            int moves = solve(i, 0, R, C, grid);
            ans = Math.max(moves, ans);
        }

        return ans;
    }

    public int solve(int i, int j, int R, int C, int[][] grid){

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int a = Integer.MIN_VALUE;
        if(i - 1 >= 0 && j + 1 < C && grid[i][j] < grid[i - 1][j + 1]){
            a = solve(i - 1, j + 1, R, C, grid) + 1;
        }

        int b = Integer.MIN_VALUE;
        if(i >= 0 && j + 1 < C && grid[i][j] < grid[i][j + 1]){
            b = solve(i, j + 1, R, C, grid) + 1;
        }

        int c = Integer.MIN_VALUE;
        if(i + 1 < R && j + 1 < C && grid[i][j] < grid[i + 1][j + 1]){
            c = solve(i + 1, j + 1, R, C, grid) + 1;
        }

        return dp[i][j] = Math.max(a, Math.max(b, c)) == Integer.MIN_VALUE ? 0 : Math.max(a, Math.max(b, c));
    }
}