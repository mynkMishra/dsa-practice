class Solution {
    public void sortColors(int[] nums) {
        
        int N = nums.length;
        int l = 0;
        while(l < N && nums[l] == 0){
            l++;
        }

        int r = l + 1;
        while(r < N){

            if(nums[r] == 0){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
            r++;
        }

        l = 0;
        while(l < N && (nums[l] == 0 || nums[l] == 1)){
            l++;
        }

        r = l + 1;
        while(r < N){
            if(nums[r] == 1){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
            r++;
        }
    }
}