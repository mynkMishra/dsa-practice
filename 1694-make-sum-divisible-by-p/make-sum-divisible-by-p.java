class Solution {
    public int minSubarray(int[] nums, int p) {
        int N = nums.length;

        long sum = 0;
        for(int el: nums){
            sum += (long)el;
        }
        long target = sum % (long)p;
        
        if(target == 0){
            return 0;
        }

        int diff = Integer.MAX_VALUE;
        long total = 0;

        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(total, -1);

        for(int i = 0; i < N; i++){
            total += (long)nums[i];

            long key = (total - target)%p;

            if(hm.get(key) != null){
                diff = Math.min(diff, i - hm.get(key));
            }

            hm.put(total%p, i);
        }

        if(diff == Integer.MAX_VALUE || diff == N){
            return -1;
        }

        return diff;
    }
}
