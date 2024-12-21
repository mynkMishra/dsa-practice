class Solution {
    public int majorityElement(int[] nums) {
        int candidate = Integer.MIN_VALUE;
        int count = 0;

        for(int el: nums){
            if(count == 0){
                candidate = el;
                count++;
            }else if(el != candidate){
                count--;
            }else if(el == candidate){
                count++;
            }
        }

        return candidate;
    }
}