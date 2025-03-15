class Solution {
    public int minCapability(int[] nums, int k) {
        
        int N = nums.length;
        int l = Integer.MAX_VALUE;
        int r = 0;

        for(int el: nums){
            l = Math.min(el, l);
            r = Math.max(el, r);
        }

        while(l <= r){
            int mid = l + (r - l)/2;

            if(solve(mid, nums, k)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

    public boolean solve(int max, int[] nums, int k){

        int last = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= max && (last == -1 || i - last > 1)){
                last = i;
                k--;
            }
        }

        return k <= 0;
    }
}