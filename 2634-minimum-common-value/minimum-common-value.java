class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int el: nums1){
            map.put(el, map.getOrDefault(el, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for(int el: nums2){
            if(map.get(el) != null){
                min = Math.min(min, el);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}