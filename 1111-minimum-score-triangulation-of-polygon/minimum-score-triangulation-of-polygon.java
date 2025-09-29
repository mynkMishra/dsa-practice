class Solution {

    int[][] dp;
    public int minScoreTriangulation(int[] values) {
        dp = new int[values.length][values.length];

        for(int[] arr: dp){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return dfs(0, values.length - 1, values);
    }

    public int dfs(int i, int j, int[] values){
        if(j - i < 2){
            return 0;
        }

        if(dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++){
            min = Math.min(min, values[i]*values[j]*values[k] + dfs(i, k, values) + dfs(k, j, values));
        }

        return dp[i][j] = min;
    }
}