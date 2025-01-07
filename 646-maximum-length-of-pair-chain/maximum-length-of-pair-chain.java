class Solution {

    int[][] memo;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        memo = new int[pairs.length + 2][pairs.length + 2];
        for(int[] m: memo){
            Arrays.fill(m, -1);
        }
        return dp(-1, 0, pairs);
    }

    public int dp(int prevIdx, int currIdx, int[][] pairs){

        if(currIdx == pairs.length){
            return 0;
        }

        if(memo[prevIdx + 1][currIdx + 1] != -1){
            return memo[prevIdx + 1][currIdx + 1];
        }

        int take = Integer.MIN_VALUE;
        if(prevIdx == -1 || pairs[prevIdx][1] < pairs[currIdx][0]){
            take = dp(currIdx, currIdx + 1, pairs) + 1;
        }

        int skip = dp(prevIdx, currIdx + 1, pairs);

        return memo[prevIdx + 1][currIdx + 1] = Math.max(skip, take);
    }
}