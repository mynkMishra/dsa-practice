class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        
        long count = 0;
        long equals = 0;
        Map<Integer, Long> hm = new HashMap<>();
        hm.put(0, 1L);

        for(int i = 0; i < nums.size(); i++){
            int el = nums.get(i);
            if(el % modulo == k) equals++;

            int rem = (int)(equals%modulo);
            int needed = (rem - k + modulo)%modulo;
            count += hm.getOrDefault(needed, 0L);
            hm.put(rem, hm.getOrDefault(rem, 0L) + 1);
        }

        return count;
    }
}