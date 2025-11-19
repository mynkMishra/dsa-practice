class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        Arrays.sort(nums);
        for(int el: nums){
            if(el == original){
                original = original*2;
            }
        }

        return original;
    }
}