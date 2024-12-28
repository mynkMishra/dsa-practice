class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int N = nums.length - k + 1;
        int[] sums = new int[N];

        int windowSum = 0;
        for(int i = 0; i < k; i++){
            windowSum += nums[i];
        }
        sums[0] = windowSum;

        for(int i = k; i < nums.length; i++){
            windowSum = windowSum - nums[i - k] + nums[i];
            sums[i - k + 1] = windowSum;
        }

        int[][] memo = new int[N][4];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        List<Integer> indices = new ArrayList<Integer>();

        dp(0, sums, k, 3, memo);
        
        dfs(sums, k, 0, 3, memo, indices);

        int[] ans = new int[3];
        for(int i = 0; i < 3; i++){
            ans[i] = indices.get(i);
        }

        return ans;
    }

    public int dp(int idx, int[] sums, int k, int rem, int[][] memo){

        if(rem == 0){
            return 0;
        }

        if(idx >= sums.length){
            return rem > 0 ? Integer.MIN_VALUE : 0;
        }

        if(memo[idx][rem] != -1){
            return memo[idx][rem];
        }

        int withCurrent = sums[idx] + dp(idx + k, sums, k, rem - 1, memo);

        int skipCurrent = dp(idx + 1, sums, k, rem, memo);

        return memo[idx][rem] = Math.max(withCurrent, skipCurrent);
    }

    public void dfs(int[] sums,
        int k,
        int idx,
        int rem,
        int[][] memo,
        List<Integer> indices){

        if (rem == 0) return;
        if (idx >= sums.length) return;

        int withCurrent = sums[idx] + dp(idx + k, sums, k, rem - 1, memo);
        int skipCurrent = dp(idx + 1, sums, k, rem, memo);

        // Choose path that gave optimal result in DP
        if (withCurrent >= skipCurrent) { // Take current subarray
            indices.add(idx);
            dfs(sums, k, idx + k, rem - 1, memo, indices);
        } else { // Skip current subarray
            dfs(sums, k, idx + 1, rem, memo, indices);
        }
    }
}