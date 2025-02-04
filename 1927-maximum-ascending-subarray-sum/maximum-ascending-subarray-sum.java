class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = -1;
        int sum = nums[0];

        for(int i =  1; i < nums.length; i++){
            if(nums[i - 1] < nums[i]){
                sum += nums[i];
            }else{
                ans = Math.max(ans, sum);
                sum = nums[i];
            }
        }

        ans = Math.max(ans, sum);
        return ans;
    }
}