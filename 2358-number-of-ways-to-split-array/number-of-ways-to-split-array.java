class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;

        for(int el: nums){
            totalSum += el;
        }

        int count = 0;
        long sum = 0;
        for(int i = 0; i < nums.length - 1; i++){
            sum += (long)nums[i];
            if(totalSum - sum <= sum){
                count++;
            }
        }

        return count;
    }
}