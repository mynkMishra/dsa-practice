class Solution {

    int max = 0;
    public int countMaxOrSubsets(int[] nums) {

        for(int el: nums){
            max = (max | el);
        }

        int ans = solve(0, 0, nums);

        return ans;
    }

    public int solve(int idx, int orVal, int[] nums){
        if(idx == nums.length){
            return orVal == max ? 1 : 0;
        }

        int a1 = solve(idx + 1, (nums[idx] | orVal), nums);
        int a2 = solve(idx + 1, orVal, nums);
        return a1 + a2;
    }
}