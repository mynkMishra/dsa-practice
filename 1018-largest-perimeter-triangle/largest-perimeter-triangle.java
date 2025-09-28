class Solution {
    public int largestPerimeter(int[] nums) {
        
        int N = nums.length;
        Arrays.sort(nums);

        for(int i = N - 1; i >=2; i--){
            if(nums[i - 1] + nums[i - 2] > nums[i]){
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }

        return 0;
    }
}