class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int min_diff = Integer.MAX_VALUE;
        int abs_min_diff = Integer.MAX_VALUE;

        for(int i = 0; i < N - 2; i++){
            int j = i + 1;
            int k = N - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = target - sum;

                if(abs_min_diff > Math.abs(diff)){
                    abs_min_diff = Math.abs(diff);
                    min_diff = diff;
                }

                if(diff > 0){
                    j++;
                }else if(diff < 0){
                    k--;
                }else{
                    return target;
                }
            }
        }

        return target - min_diff;
    }
}