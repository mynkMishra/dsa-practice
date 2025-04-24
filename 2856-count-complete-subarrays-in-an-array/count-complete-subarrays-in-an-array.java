class Solution {
    public int countCompleteSubarrays(int[] nums) {
        
        int N = nums.length;
        Set<Integer> totalHs = new HashSet<>();

        for(int el: nums){
            totalHs.add(el);
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            Set<Integer> hs = new HashSet<>();
            for(int j = i; j < N; j++){
                hs.add(nums[j]);
                if(hs.size() == totalHs.size()){
                    count++;
                }
            }
        }

        return count;
    }
}