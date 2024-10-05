class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int el: nums){
            hm.put(el, hm.getOrDefault(el, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> e: hm.entrySet()){
            if(e.getValue() == 1){
                max = Math.max(max, e.getKey());
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}