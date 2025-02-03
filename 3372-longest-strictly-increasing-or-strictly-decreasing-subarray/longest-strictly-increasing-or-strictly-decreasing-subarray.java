class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int count = 1;
        int ans = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] < nums[i]){
                count++;
            }else{
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        ans = Math.max(ans, count);

        count = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i + 1]){
                count++;
            }else{
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        ans = Math.max(ans, count);

        return ans;

    }
}