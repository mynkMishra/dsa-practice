class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int N = nums.length;
        int l = 0;
        int r = 0;
        int count = 0;
        int prod = 1;

        while(r < N){
            prod *= nums[r];

            while(prod >= k && l <= r){
                prod /= nums[l];
                l++;
            }

            count += (r - l + 1);
            r++;
        }

        return count;
    }
}