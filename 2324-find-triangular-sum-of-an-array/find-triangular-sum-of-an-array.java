class Solution {
    public int triangularSum(int[] nums) {
        int N = nums.length;

        int[][] memo = new int[N][N];

        for(int i = 0; i < N; i++){
            memo[0][i] = nums[i];
        }

        int C = N - 1;
        for(int i = 1; i < N; i++){
            for(int j = 0; j < C; j++){
                memo[i][j] = (memo[i - 1][j] + memo[i - 1][j + 1])%10;
            }
            C--;
        }

        return memo[N - 1][0];
    }
}