class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int el: nums){
            hm.put(el, hm.getOrDefault(el, 0) + 1);
        }

        int round = 0;
        for(Map.Entry<Integer, Integer> e: hm.entrySet()){
            int freq = e.getValue();
            if(freq == 1){
                return -1;
            }

            round += freq/3;
            freq = freq%3;
            round += freq == 1 || freq == 2 ? 1 : 0;
        }

        return round;
    }
}