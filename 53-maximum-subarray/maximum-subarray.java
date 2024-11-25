class Solution {

    int ans = Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        solve(1, 0, nums);
        solve(1, nums[0], nums);

        if(ans == 0){
            int v = Integer.MIN_VALUE;
            for(int a: nums){
                v = Math.max(a, v);
            }

            ans = v;
        }
        return ans;
    }

    public void solve(int idx, int sum, int[] nums){

        ans = Math.max(ans, sum);

        if(idx == nums.length){
            return;
        }

        if(sum + nums[idx] > nums[idx]){
            solve(idx + 1, sum + nums[idx], nums);
        }else{
            solve(idx + 1, nums[idx], nums);
        }

    }
}