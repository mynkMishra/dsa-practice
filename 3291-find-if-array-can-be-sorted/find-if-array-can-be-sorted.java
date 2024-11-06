class Solution {
    public boolean canSortArray(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            int el = nums[i];
            int count = 0;
            while(el > 0){
                if((el & 1) == 1){
                    count++;
                }
                el = (el >> 1);
            }

            hm.put(nums[i], count);
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    if(hm.get(nums[i]) != hm.get(nums[j])){
                        return false;
                    }

                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return true;
        
    }
}