class Solution {
    public long maximumTripletValue(int[] nums) {

        int N = nums.length;
        int[] prefix_max = new int[N];
        prefix_max[0] = nums[0];

        for(int i = 1; i < N; i++){
            prefix_max[i] = Math.max(prefix_max[i - 1], nums[i - 1]);
        }

        int[] suffix_max = new int[N];
        suffix_max[N - 1] = 0;

        for(int i = N - 2; i >= 0; i--){
            suffix_max[i] = Math.max(suffix_max[i + 1], nums[i + 1]);
        }

        long ans = -1;

        for(int i = 0; i < N; i++){
            ans = Math.max(ans, (long)((long)prefix_max[i] - (long)nums[i])*(long)suffix_max[i]);
        }

        return ans < 0 ? 0 : ans;
    }
}