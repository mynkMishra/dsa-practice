class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int el: nums){
            sum += el;
        }

        if(sum%2 != 0){
            return false;
        }

        int N = nums.length;
        boolean[][] dp = new boolean[N + 1][sum/2 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= sum/2; j++){
                if(j >= nums[i - 1]){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }  
            }
        }

        // for(int i = 0; i <= N; i++){
        //     for(int j = 0; j <= sum/2; j++){
        //         System.out.print(dp[i][j] + " ");  
        //     }
        //     System.out.println();
        // }

        return dp[N][sum/2];
    }
}