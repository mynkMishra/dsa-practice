class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();

        long ans = 0;
        int N = nums.length;
        int l = 0;
        int r = 0;
        long count = 0;
        while(r < N){

            if(count >= k){
                ans += (N - r + 1);
                hm.put(nums[l], hm.get(nums[l]) - 1);
                count -= hm.get(nums[l]);
                if(hm.get(nums[l]) == 0){
                    hm.remove(nums[l]);
                }

                l++;
            }else{
                count += hm.getOrDefault(nums[r], 0);
                hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
                r++;
            }
        }

        while(l < N){
            if(count >= k){
                ans++;
                hm.put(nums[l], hm.get(nums[l]) - 1);
                count -= hm.get(nums[l]);
                if(hm.get(nums[l]) == 0){
                    hm.remove(nums[l]);
                }
                l++;
            }else{
                break;
            }
        }

        return ans;
    }
}