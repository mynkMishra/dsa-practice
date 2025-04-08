class Solution {
    public int minimumOperations(int[] nums) {
        
        Map<Integer, Integer> hm = new HashMap<>();

        int count = 0;
        for(int el: nums){
            if(hm.containsKey(el) && hm.get(el) == 1){
                count++;
            }
            hm.put(el, hm.getOrDefault(el, 0) + 1);
            
        }

        if(count == 0){
            return 0;
        }

        int i = 0;
        int ops = 0;
        while(i < nums.length){
            for(int x = 0; x < 3 && i < nums.length; x++){
                hm.put(nums[i], hm.get(nums[i]) - 1);

                if(hm.get(nums[i]) == 1){
                    count--;
                }

                if(hm.get(nums[i]) == 0){
                    hm.remove(nums[i]);
                }
                i++;
            }
            ops++;

            if(count == 0){
                break;
            }
            
        }

        return ops;

    }
}