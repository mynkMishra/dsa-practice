class Solution {
    public int[] resultsArray(int[] nums, int k) {
        
        int N = nums.length;
        int[] ans = new int[N - k + 1];
        for(int i = 0; i < N - k + 1; i++){
            boolean valid = true;
            for(int j = i; j < i + k - 1; j++){
                if(nums[j] + 1 != nums[j + 1]){
                    valid = false;
                }
            }

            ans[i] = valid ? nums[i + k - 1] : -1;
        }

        return ans;
    }
}