class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();

        int max = 0;
        for(int n: nums){
            hm.put(n, hm.getOrDefault(n, 0) + 1);

            max = Math.max(max, hm.get(n));
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> e: hm.entrySet()){
            if(e.getValue().equals(max)){
                ans+=max;
            }
        }

        return ans;

    }
}