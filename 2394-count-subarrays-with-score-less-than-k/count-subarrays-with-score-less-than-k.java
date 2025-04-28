class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        int N = nums.length;
        long sum = 0;
        int left = 0;
        long ans = 0;

        for(int right = 0; right < N; right++){
            sum += nums[right];

            while(left <= right && sum*(right - left + 1) >= k){
                sum -= (long)nums[left];
                left++;
            }

            ans += (right - left + 1);
        }

        return ans;
    }
}