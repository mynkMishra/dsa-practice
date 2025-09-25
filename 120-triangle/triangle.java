class Solution {

    int[][] dp;
    int N;
    public int minimumTotal(List<List<Integer>> triangle) {
        N = triangle.size();
        dp = new int[N + 1][N + 1];

        for(int i = 0; i < dp[0].length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        return run(triangle, 0, 0);
    }

    public int run(List<List<Integer>> A, int i, int j){

        if(i == A.size()){
            return 0;
        }

        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int s1 = run(A, i + 1, j);
        int s2 = run(A, i + 1, j + 1);

        return dp[i][j] = Math.min(A.get(i).get(j) + s1, A.get(i).get(j) + s2);
    }
}