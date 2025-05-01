class Solution {

    int[][] memo;
    public int bestTeamScore(int[] scores, int[] ages) {
        int N = scores.length;

        int[][] arr = new int[N][2];
        memo = new int[N + 1][N + 1];

        for(int i = 0; i < N; i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(int[] d: memo){
            Arrays.fill(d, -1);
        }

        return solve(0, -1, arr);
    }

    public int solve(int idx, int highScoreIdx, int[][] arr){

        if(idx == arr.length){
            return 0;
        }

        if(memo[idx][highScoreIdx + 1] != -1){
            return memo[idx][highScoreIdx + 1];
        }

        int taken = Integer.MIN_VALUE;
        if(highScoreIdx == -1 || arr[idx][1] >= arr[highScoreIdx][1]){
            int hIdx = highScoreIdx != -1 && Math.max(arr[highScoreIdx][1], arr[idx][1]) == arr[highScoreIdx][1] 
                        ? highScoreIdx : idx;
            taken = solve(idx + 1, hIdx, arr) + arr[idx][1];
        }

        int skip = solve(idx + 1, highScoreIdx, arr);

        return memo[idx][highScoreIdx + 1] = Math.max(taken, skip);
    }
}