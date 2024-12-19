class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        
        if(nums.length == 1){
            return Math.abs(nums[0] - k);
        }

        Arrays.sort(nums);
        int N = nums.length;
        long ops = 0;

        if(N%2 == 0){
            int median = nums[N/2];
            if(k < median){
               
                ops += median - k;
                int start = N/2;
                nums[N/2] = k;
                for(int i = start; i > 0; i--){
                    if(nums[i] < nums[i - 1]){
                        ops += nums[i - 1] - nums[i];
                        nums[i - 1] = nums[i];
                    }
                }
            }else if(k == median){
                return ops;
            }else{
                ops += k - median;
                nums[N/2] = k;
                for(int i = N/2; i < N - 1; i++){
                    if(nums[i + 1] < nums[i]){
                        ops += nums[i] - nums[i + 1];
                        nums[i + 1] = nums[i];
                    }
                }
            }
        }else{
            int median = nums[N/2];
            if(k < median){
                ops += median - k;
                nums[N/2] = k;
                for(int i = N/2; i > 0; i--){
                    if(nums[i] < nums[i - 1]){
                        ops += nums[i - 1] - nums[i];
                        nums[i - 1] = nums[i];
                    }
                }
            }else if(k == median){
                return ops;
            }else{
                ops += k - median;
                nums[N/2] = k;
                for(int i = N/2; i < N - 1; i++){
                    if(nums[i + 1] < nums[i]){
                        ops += nums[i] - nums[i + 1];
                        nums[i + 1] = nums[i];
                    }
                }
            }
        }

        return ops;
        
    }
}