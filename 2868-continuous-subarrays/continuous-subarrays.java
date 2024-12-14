class Solution {
    public long continuousSubarrays(int[] nums) {

        int N = nums.length;
        int l = 0;
        int r = 0;

        int currMin = nums[0];
        int currMax = nums[0];
        long winLen = 0;
        long total = 0;

        while(r < N){
            currMin = Math.min(currMin, nums[r]);
            currMax = Math.max(currMax, nums[r]);

            if(currMax - currMin > 2){
                winLen = r - l;
                total += (long)winLen*((long)winLen + 1)/2;
                l = r;
                currMin = nums[r];
                currMax = nums[r];

                while(l > 0 && Math.abs(nums[r] - nums[l - 1]) <= 2){
                    l--;
                    currMin = Math.min(currMin, nums[l]);
                    currMax = Math.max(currMax, nums[l]);
                }

                if(l < r){
                    winLen = r - l;
                    total -= (long)winLen*((long)winLen + 1)/2;
                }
            }
            r++;
        }

        winLen = r - l;
        total += (long)winLen*((long)winLen + 1)/2;

        return total;
    }
}