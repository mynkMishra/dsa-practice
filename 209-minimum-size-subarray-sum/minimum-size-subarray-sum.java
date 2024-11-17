class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int N = nums.length;
        int ans = Integer.MAX_VALUE;

        while(r < N){
            if(sum < target){
                sum += nums[r];
                r++;
            }else{
                ans = Math.min(ans, r - l);
                sum -= nums[l];
                l++;
            }
        }

        while(l < N && sum >= target){
            ans = Math.min(ans, r - l);
            sum -= nums[l];
            l++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}