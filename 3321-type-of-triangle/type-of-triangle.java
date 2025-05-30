class Solution {
    public String triangleType(int[] nums) {

        Arrays.sort(nums);

        if(nums[0] + nums[1] <= nums[2]){
            return "none";
        }
        
        if(nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]){
            return "scalene";
        }

        if(nums[0] == nums[1] && nums[1] == nums[2]){
            return "equilateral";
        }

        return "isosceles";
    }
}