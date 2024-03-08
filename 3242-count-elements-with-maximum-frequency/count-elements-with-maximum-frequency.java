class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = Integer.MIN_VALUE;
        for(int el: nums){
            map.put(el, map.getOrDefault(el, 0) + 1);
            max = Math.max(max, map.get(el));
        }

        int total = 0;
        for(Integer key: map.keySet()){
            if(map.get(key) == max){
                total += map.get(key);
            }
        }

        return total;
    }
}