class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i< nums.length; i++){
            map.put(nums[i], i);
        }

        int[] res = new int[2];

        for(int i = 0; i< nums.length; i++){
            int reqEl = target - nums[i];

            if(map.get(reqEl) != null && map.get(reqEl) != i){
                res[0] = i;
                res[1] = map.get(reqEl);

                return res;
            }
        }

        return res;
    }
}