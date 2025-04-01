class Solution {

    long[] dp;
    public long mostPoints(int[][] questions) {

        dp = new long[questions.length];

        Arrays.fill(dp, -1);
        return solve(0, questions);
    }

    public long solve(int idx, int[][] questions){

        if(idx >= questions.length){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        long solve = (long)questions[idx][0] + solve(idx + questions[idx][1] + 1, questions);

        long skip = solve(idx + 1, questions);

        return dp[idx] = Math.max(solve, skip);
    }
}