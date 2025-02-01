class Solution {
    public boolean isArraySpecial(int[] nums) {
        
        for(int i = 1; i < nums.length; i++){
            int a = (nums[i - 1] & 1);
            int b = (nums[i] & 1);

            if((a^b) == 0){
                return false;
            }
        }

        return true;
    }
}