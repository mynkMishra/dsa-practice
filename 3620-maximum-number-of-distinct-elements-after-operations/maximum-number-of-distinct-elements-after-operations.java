class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int N = nums.length;
        nums[0] = nums[0] - k;

        int lastSeen = nums[0];
        Set<Integer> hs = new HashSet<Integer>();
        hs.add(nums[0]);
        
        for(int i = 1; i < N; i++){
            if(nums[i] - lastSeen > k){
                nums[i] = nums[i] - k;
                lastSeen = nums[i];
            }else{
                if(lastSeen + 1 - nums[i] <= k){
                    nums[i] = lastSeen + 1;
                    lastSeen = nums[i];
                }
            }

            hs.add(nums[i]);
        }

        return hs.size();
        
    }
}