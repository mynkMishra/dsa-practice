class Solution {
    public int getLargestOutlier(int[] nums) {
        
        int sumT = 0;

        for(int el: nums){
            sumT += el;
        }

        Map<Integer, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int el = nums[i];
            if(hm.get(el) == null){
                hm.put(el, new ArrayList<>());
            }
            hm.get(el).add(i);
        }

        int ans = Integer.MIN_VALUE;
        for(int el: nums){
            int diff = sumT - el;
            if(diff%2 == 0){
                if(hm.containsKey(diff/2)){
                    if(el == diff/2){
                        if(hm.get(el).size() > 1){
                            ans = Math.max(ans, el);
                        }
                    }else{
                        ans = Math.max(ans, el);
                    }
                }
            }
        }

        return ans;
    }
}