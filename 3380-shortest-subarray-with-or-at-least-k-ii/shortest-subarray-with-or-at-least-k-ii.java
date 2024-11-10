class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int N = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int[] bitCounts = new int[32];

        while(end < N){
            updateBitCounts(bitCounts, nums[end], 1);

            while(start <= end && convertBitCountsToNumber(bitCounts) >= k){
                ans = Math.min(ans, end - start + 1);

                updateBitCounts(bitCounts, nums[start], -1);
                start++;
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void updateBitCounts(int[] bitCounts, int number, int delta){
        for(int idx = 0; idx < 32; idx++){
            if(((number >> idx) & 1) != 0){
                bitCounts[idx] += delta;
            }
        }
    }

    public int convertBitCountsToNumber(int[] bitCounts){
        int result = 0;

        for(int idx = 0; idx < 32; idx++){
            if(bitCounts[idx] != 0){
                result = (result | (1 << idx));
            }
        }

        return result;
    }
}