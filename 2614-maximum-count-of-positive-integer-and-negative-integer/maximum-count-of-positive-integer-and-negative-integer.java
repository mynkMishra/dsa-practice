class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;

        for(int el: nums){
            if(el < 0){
                neg++;
            }
            if(el > 0){
                pos++;
            }
        }

        return Math.max(pos, neg);
    }
}