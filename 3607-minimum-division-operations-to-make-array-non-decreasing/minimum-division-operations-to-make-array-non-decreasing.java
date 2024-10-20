class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        if(nums.length == 1){
            return 0;
        }
        
        int count = 0;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i + 1]){
                int val = hm.get(nums[i]) == null 
                            ? smallestDivisor(nums[i]) 
                            : hm.get(nums[i]);

                if(val != 0 && val <= nums[i + 1]){
                    hm.put(nums[i],val);
                    count++;
                    nums[i] = val;
                }else{
                    return -1;
                }
            }
        }

        return count;
    }

    public int smallestDivisor(int num){
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num%i == 0){
                if(i < num){
                    return i;
                }

                // if((num/i) < num){
                //     return num/i;
                // }
            }
        }

        return 0;
    }
}