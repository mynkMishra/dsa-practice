class Solution {
    public boolean divideArray(int[] nums) {
        
        int[] count = new int[501];

        for(int el: nums){
            count[el]++;
        }

        for(int i = 1; i < count.length; i++){
            if((count[i]&1) > 0){
                return false;
            }
        }

        return true;
    }
}