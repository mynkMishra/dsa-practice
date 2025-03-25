class Solution {
    public int findPeakElement(int[] nums) {

        int N = nums.length;
        int l = 0;
        int r = N - 1;

        while(l<r){
            int mid = l + (r - l)/2;

            if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == N - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }

            if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == N - 1 || nums[mid] < nums[mid + 1])){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return l;
    }
}