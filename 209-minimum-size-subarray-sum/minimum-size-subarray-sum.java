class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;

        int len = nums.length;

        int l = 0;
        int r = 0;
        boolean exceed = false;

        while(r < nums.length){
            if(sum < target){
                sum += nums[r];
                r++;
            }else{
                exceed = true;
                while(sum >= target){
                    len = Math.min(len, r - l);
                    sum -= nums[l];
                    l++;
                }

                sum += nums[r];
                r++;                
            }
        }

        while(sum >= target){
            exceed = true;
            len = Math.min(len, r - l);
            sum -= nums[l];
            l++;
        }

        if(!exceed){
            // System.out.println(sum);
            return 0;
        }

        return len;
    }
}