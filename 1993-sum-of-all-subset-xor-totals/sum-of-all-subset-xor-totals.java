class Solution {

    int sum = 0;
    public int subsetXORSum(int[] nums) {
        solve(0, 0, nums);
        return sum;
    }

    public void solve(int idx, int xor, int[] nums){

        if(idx >= nums.length){
            sum += xor;
            return;
        }

        solve(idx + 1, xor^nums[idx], nums);
        solve(idx + 1, xor, nums);
    }
}