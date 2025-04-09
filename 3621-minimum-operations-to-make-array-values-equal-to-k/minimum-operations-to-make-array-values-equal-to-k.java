class Solution {
    public int minOperations(int[] nums, int k) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> hs = new HashSet<>();

        for(int el: nums){
            min = Math.min(min, el);
            max = Math.max(max, el);
            hs.add(el);
        }

        if(k > min){
            return -1;
        }

        if(k == min){
            return hs.size() - 1;
        }

        return hs.size();
    }
}