class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = 0;
        int i = 0;
        while(i < nums.length && nums[i] < 0){
            i++;
        }

        left = i - 1;
        right = i;
        i = 0;
        while(i < nums.length && left >= 0 && right < nums.length){
            if(Math.abs(nums[left]) >= nums[right]){
                ans[i] = nums[right]*nums[right];
                right++;
            }else{
                ans[i] = nums[left]*nums[left];
                left--;
            }
            i++;
        }

        while(left >= 0){
            ans[i] = nums[left]*nums[left];
            i++;
            left--;
        }

        while(right < nums.length){
            ans[i] = nums[right]*nums[right];
            i++;
            right++;
        }

        return ans;
    }
}