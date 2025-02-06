class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Long, Integer> hm = new HashMap<Long, Integer>();
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                
                int b = nums[j];

                long r = (long)a*(long)b;

                sum += 8 * hm.getOrDefault(r, 0);
                hm.put(r, hm.getOrDefault(r, 0) + 1);
            }
        }

        return sum;
    }
}