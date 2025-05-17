class Solution {
    public int maxKilledEnemies(char[][] grid) {
        
        int M = grid.length;
        int N = grid[0].length;

        int[][] dp = new int[M + 1][N + 1];

        int[][] top = new int[M + 2][N + 2];
        int[][] left = new int[M + 2][N + 2];

        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(grid[i - 1][j - 1] != 'E' && grid[i - 1][j - 1] != 'W'){
                    dp[i][j] += top[i - 1][j] + left[i][j - 1];
                }

                if(grid[i - 1][j - 1] == 'E'){
                    top[i][j] = top[i - 1][j] + 1;
                    left[i][j] = left[i][j - 1] + 1;
                }else if(grid[i - 1][j - 1] == 'W'){
                    top[i][j] = 0;
                    left[i][j] = 0;
                }else{
                    top[i][j] = top[i - 1][j];
                    left[i][j] = left[i][j - 1];
                }
                
            }
        }
        
        top = new int[M + 2][N + 2];
        left = new int[M + 2][N + 2];
        int ans = 0;

        for(int i = M; i > 0; i--){
            for(int j = N; j > 0; j--){
                if(grid[i - 1][j - 1] != 'E' && grid[i - 1][j - 1] != 'W'){
                    dp[i][j] += top[i + 1][j] + left[i][j + 1];
                    ans = Math.max(ans, dp[i][j]);
                }

                if(grid[i - 1][j - 1] == 'E'){
                    top[i][j] = top[i + 1][j] + 1;
                    left[i][j] = left[i][j + 1] + 1;
                }else if(grid[i - 1][j - 1] == 'W'){
                    top[i][j] = 0;
                    left[i][j] = 0;
                }else{
                    top[i][j] = top[i + 1][j];
                    left[i][j] = left[i][j + 1];
                }
                
            }
        }

        return ans;
    }
}