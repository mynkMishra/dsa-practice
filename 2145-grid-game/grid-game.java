class Solution {
    public long gridGame(int[][] grid) {

        int N = 2;
        int M = grid[0].length;
        long[] prefix = new long[M];

        prefix[0] = (long)grid[0][0];

        for(int i = 1; i < M; i++){
            prefix[i] = prefix[i - 1] + (long)grid[0][i];
        }

        long[] suffix = new long[M];

        suffix[M - 1] = grid[1][M - 1];

        for(int i = M - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] + (long)grid[1][i];
        }

        long ans = Long.MAX_VALUE;
        for(int j = 0; j < M; j++){
            ans = Math.min(ans, Math.max(prefix[M - 1] - prefix[j], suffix[0] - suffix[j]));
        }

        return ans;
    }
}