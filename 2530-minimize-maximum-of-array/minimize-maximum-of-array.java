class Solution {

    public int minimizeArrayValue(int[] nums) {
        
        int N = nums.length;
        long l = 0;
        long r = 0;

        for(int i = N - 1; i >= 0; i--){
            r += (long)nums[i];
        }

        

        while(l<=r){
            long mid = l + (r - l)/2;

            long max = isPossible(mid, nums);

            if(mid >= max){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return (int)l;
    }

    public long isPossible(long el, int[] nums){

        long count = 0;
        for(int i = nums.length - 1; i >= 1; i--){
            if(nums[i] >= el){
                count += (long)nums[i] - el;
            }else{
                long diff = el - (long)nums[i];
                count -= diff;
                count = Math.max(0, count);
            }
        }

        return (long)nums[0] + count;
    }
}