class Solution {
    public int countPairs(List<Integer> nums, int target) {
        
        int N = nums.size();
        int ans = 0;

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(nums.get(i) + nums.get(j) < target){
                    ans++;
                }
            }
        }

        return ans;
    }
}