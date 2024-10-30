class Solution {

    int[][] dpL;
    int[][] dpR;
    public int minimumMountainRemovals(int[] nums) {
        
        int N = nums.length;
        int ans = Integer.MAX_VALUE;

        dpL = new int[N][N];
        dpR = new int[N][N];

        for(int[] d: dpL){
            Arrays.fill(d, -1);
        }

        for(int[] d: dpR){
            Arrays.fill(d, -1);
        }

        for(int i = 1; i < N - 1; i++){
            int leftCount = checkForLeft(i - 1, i, nums);
            int rightCount = checkForRight(i + 1, i, nums);
            if(leftCount != i && rightCount != (N - i - 1)){
                ans = Math.min(ans, leftCount + rightCount);
            }            
        }
        return ans;
    }

    public int checkForLeft(int idx, int prev, int[] nums){

        if(idx < 0){
            return 0;
        }

        if(dpL[idx][prev] != -1){
            return dpL[idx][prev];
        }

        if(nums[idx] >= nums[prev]){
            return dpL[idx][prev] = checkForLeft(idx - 1, prev, nums) + 1;
        }else{
            int a = checkForLeft(idx - 1, idx, nums);
            int b = checkForLeft(idx - 1, prev, nums) + 1;

            return dpL[idx][prev] = Math.min(a, b);
        }
    }

    public int checkForRight(int idx, int prev, int[] nums){

        if(idx == nums.length){
            return 0;
        }

        if(dpR[idx][prev] != -1){
            return dpR[idx][prev];
        }
        
        if(nums[idx] >= nums[prev]){
            return dpR[idx][prev] = checkForRight(idx + 1, prev, nums) + 1;
        }else{
            int a = checkForRight(idx + 1, idx, nums);
            int b = checkForRight(idx + 1, prev, nums) + 1;

            return dpR[idx][prev] = Math.min(a, b);
        }
    }
}