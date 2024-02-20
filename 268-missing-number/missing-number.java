class Solution {
    public int missingNumber(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        boolean[] arr = new boolean[max + 2];

        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] = true;
        }

        for(int i = 0; i< arr.length; i++){
            if(!arr[i]){
                return i;
            }
        }

        return max + 1;

    }
}