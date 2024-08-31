class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        int N  = nums.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < N - 2; i++){
            int j = i + 1;
            int k = N - 1;
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{

                    String key = nums[i] + "#" + nums[j] + "#" + nums[k];
                    if(map.get(key) == null){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        list.add(l);
                        map.put(key, 1);
                    }
                    
                    j++;
                }
            }
        }
        
        return list;
    }
}