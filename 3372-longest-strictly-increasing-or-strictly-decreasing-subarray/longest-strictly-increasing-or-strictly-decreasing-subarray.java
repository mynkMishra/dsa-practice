class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int l = 0;
        int r = 0;

        int ans = 0;
        while(r < nums.length - 1){
            if(nums[r] < nums[r + 1]){
                if((r == 0 || nums[r - 1] >= nums[r])){
                    ans = Math.max(ans, r - l + 1);
                    l = r;
                }
                r++;
            }else if(nums[r] == nums[r + 1]){
                ans = Math.max(ans, r - l + 1);
                while(r < nums.length - 1 && nums[r] == nums[r + 1]){
                    r++;
                }
                l = r;
            }else{
                if((r == 0 || nums[r - 1] <= nums[r])){
                    ans = Math.max(ans, r - l + 1);
                    l = r;
                }
                r++;
            }
        }

        ans = Math.max(ans, r - l + 1);

        return ans;
    }
}