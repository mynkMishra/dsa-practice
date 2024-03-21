class Solution {
    public int findMaxLength(int[] nums) {
        int[] sums = new int[nums.length + 1];

        for(int i = 1; i < sums.length; i++){
            sums[i] = nums[i - 1] == 1 ? sums[i - 1] + 1 : sums[i - 1] - 1;
        }

        int ans = -1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < sums.length; i++){
            if(map.get(sums[i]) == null){
                map.put(sums[i], i );
            }else{
                ans = Math.max(ans, i - map.get(sums[i]));
            }
        }

        return ans == -1 ? 0 : ans;

    }
}