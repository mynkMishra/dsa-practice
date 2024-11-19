class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int N = nums.length;
        long sum = 0;
        long ans = Integer.MIN_VALUE;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int l = 0;
        int r = 0;

        while(r < N){
            if(r - l < k){
                sum += nums[r];
                hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
                r++;
            }else{
                if(hm.size() == k){
                    ans = Math.max(ans, sum);
                }

                sum -= nums[l];

                hm.put(nums[l], hm.get(nums[l]) - 1);
                if(hm.get(nums[l]) == 0){
                    hm.remove(nums[l]);
                }

                l++;

                hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);

                sum += (long)nums[r];
                r++;
            }
        }

        if(hm.size() == k){
            ans = Math.max(ans, sum);
        }
        
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}