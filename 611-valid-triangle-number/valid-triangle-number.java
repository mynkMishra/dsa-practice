class Solution {
    public int triangleNumber(int[] nums) {
        int N = nums.length;
        HashSet<String> hs = new HashSet<>();

        Arrays.sort(nums);

        int sum = 0;
        for(int i = 0; i < N - 2; i++){
            int k = i + 1;
            for(int j = i + 1; j < N - 1 && nums[i] != 0; j++){
                int idx = find(nums, nums[i] + nums[j], k, nums.length - 1);

                sum += (idx - (j + 1));
            }
        }

        return sum;
    }

    public int find(int[] arr, int target, int l, int r){

        while(l <= r){
            int mid = l + (r - l)/2;

            if(arr[mid] >= target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }
}