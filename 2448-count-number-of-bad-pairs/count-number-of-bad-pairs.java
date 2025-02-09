class Solution {
    public long countBadPairs(int[] nums) {
        Map<Long, Long> hm = new HashMap<Long, Long>();
        long totalSize = 0;
        long ans = 0;

        for(int i = 0; i < nums.length; i++){
            long diff = nums[i] - i;

            if(hm.get(diff) == null){
                ans += totalSize;
                hm.put(diff, hm.getOrDefault(diff, 0L ) + 1);
                totalSize++;
            }else{
                ans += (totalSize - hm.get(diff));
                hm.put(diff, hm.get(diff) + 1);
                totalSize++;
            }
        }

        return ans;
    }
}