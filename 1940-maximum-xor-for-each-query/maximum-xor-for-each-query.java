class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int N = nums.length;
        int limit = (int)Math.pow(2, maximumBit);

        int[] prefix = new int[N];

        prefix[0] = nums[0];
        for(int i = 1; i < N; i++){
            prefix[i] = (prefix[i - 1] ^ nums[i]);
        }

        int[] ans = new int[N];
        for(int i = N - 1; i >= 0; i--){
            int el = prefix[i];
                        
            int comp = el;
            int idx = 0;
            while(idx < maximumBit){
                comp = (comp ^ (1 << idx));
                idx++;
            }

            ans[N - i - 1] = comp;
        }

        return ans;
    }
}