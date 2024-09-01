class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int N = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while(r < N){

            if(sum >= target){
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }else{
                sum += nums[r];
                r++;
            }
        }

        while(sum >= target && l < N){
            res = Math.min(res, r - l + 1);
            sum -= nums[l];
            l++;
        }

        return res == Integer.MAX_VALUE ? 0 : res - 1;
    }
}