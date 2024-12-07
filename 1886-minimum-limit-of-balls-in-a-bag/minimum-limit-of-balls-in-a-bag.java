class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = -1;

        for(int el: nums){
            r = Math.max(r, el);
        }

        while(l<=r){
            int mid = l + (r - l)/2;

            if(check(mid, nums, maxOperations)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

    public boolean check(int minPen, int[] nums, int maxOp){

        int N = nums.length;
        int idx = 0;
        int ops = 0;
        while(idx < N){
            if(nums[idx] > minPen){
                if(nums[idx]%minPen == 0){
                    ops += ((nums[idx]/minPen) - 1);
                }else{
                    ops += (nums[idx]/minPen);
                }
            }
            idx++;
        }

        return ops <= maxOp;
    }
}