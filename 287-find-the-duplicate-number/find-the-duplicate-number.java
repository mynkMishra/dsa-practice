class Solution {
    public int findDuplicate(int[] nums) {
        
        int N = nums.length;
        for(int i = 0; i < N; i++){
            int x = Math.abs(nums[i]);
            int idx = x - 1;

            if(nums[idx] > 0){
                nums[idx] *= -1;
            }else{
                return x;
            }
        }

        return -1;
    }
}