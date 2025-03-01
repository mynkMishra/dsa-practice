class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int r = 0;
        while(r < nums.length && nums[r] != 0){
            r++;
        }

        int l = r + 1;

        while(l < nums.length){
            if(nums[l] != 0){
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                while(r < nums.length && nums[r] != 0){
                    r++;
                }

                l = r + 1;
            }else{
                l++;
            }
        }

        return nums;
    }
}