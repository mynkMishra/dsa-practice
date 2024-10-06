class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0){
            int[] arr = new int[2];
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        
        int N = nums.length;
        int l = 0;
        int r = N - 1;

        while(l<=r){
            int mid = l + (r - l)/2;

            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        if(l == N || nums[l] != target){
            int[] arr = new int[2];
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }

        int[] arr = new int[2];
        l = 0;
        r = N - 1;
        while(l<=r){
            int mid = l + (r - l)/2;

            if(nums[mid] < target || 
            (nums[mid] == target && (mid == N - 1 || nums[mid + 1] == target))){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        arr[1] = l == N ? l - 1 : l;
        l = 0;
        r = N - 1;
        while(l<=r){
            int mid = l + (r - l)/2;

            if(nums[mid] > target ||
            (nums[mid] == target && (mid == 0 || nums[mid - 1] == target))){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        arr[0] = r == -1 ? 0 : r;
        return arr; 
    }
}