class Solution {

    public boolean checkEqualPartitions(int[] nums, long target) {

        return find(nums.length - 1, nums, new int[nums.length], target);
    }

    public boolean find(int idx, int[] nums, int[] mask, long target){
        
        if(idx < 0){
            long part1 = 1L;
            long part2 = 1L;

            for(int i = 0; i < mask.length; i++){
                int m = mask[i];
                if(m == 1){
                    part1 = (long)(part1)*(long)nums[i];
                }
                if(m == 0){
                    part2 = (long)(part2)*(long)nums[i];
                }
            }
            return part1 == part2 && part1 == target;
        }
        
        mask[idx] = 1;
        boolean taken = find(idx - 1, nums, mask, target);
        if(taken){
            return true;
        }
        mask[idx] = 0;

        boolean skip = find(idx - 1, nums, mask, target);

        return taken || skip;
    }
}