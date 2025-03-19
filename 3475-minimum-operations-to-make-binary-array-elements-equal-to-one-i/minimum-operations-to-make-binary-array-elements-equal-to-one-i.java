class Solution {
    public int minOperations(int[] nums) {
        int l = 0;
        int r = nums.length;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(solve(mid, nums.clone())){
                r = mid  - 1;
            }else{
                l = mid + 1;
            }
        }

        return l > nums.length ? -1 : l;
    }

    public boolean solve(int k, int[] nums){

        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] == 0){
                if(k > 0){
                    nums[i] = (nums[i] ^ 1);
                    nums[i + 1] = (nums[i + 1] ^ 1);
                    nums[i + 2] = (nums[i + 2] ^ 1);
                    count++;
                    k--;
                }else{
                    break;
                }
            }else{
                count++;
            }
        }

        if(nums[nums.length - 1] == 1){
            count++;
        }
        if(nums[nums.length -2] == 1){
            count++;
        }

        return nums.length == count;
    }
}