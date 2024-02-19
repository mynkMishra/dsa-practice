class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int r = 0;
        int[][] result = new int[nums.length/3][3];
        for(int i = 0; i < nums.length; i+=3){
            int[] arr = new int[3];
            if(
                nums[i + 1] - nums[i] <= k && 
                nums[i + 2] - nums[i + 1] <= k && 
                nums[i + 2] - nums[i] <= k
            ){
                arr[0] = nums[i]; 
                arr[1] = nums[i + 1]; 
                arr[2] = nums[i + 2]; 
                result[r] = arr;
                r++;
            }else{
                return new int[0][0];
            }
        }

        return result;
    }
}