class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int N = nums.length;
        int[] prefix = new int[N];

        prefix[0] = nums[0];

        for(int i = 1; i < N; i++){
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // -2, -3, -1, 0
        int ans = 0;

        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        for(int i = 0; i < N; i++){
            if(hm.get(prefix[i] - k) != null){
                ans = Math.max(ans, i - hm.get(prefix[i] - k));
            }
            if(hm.get(prefix[i]) == null){
                hm.put(prefix[i], i);
            }
        }

        return ans;
    }
}