class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        return create(0, nums);
    }  

    public List<List<Integer>> create(int i, int[] nums){

        if(i == nums.length){
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            res.add(new ArrayList<Integer>());
            return res;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<List<Integer>> list = create(i + 1, nums);

        for(List<Integer> l: list){
            List<Integer> r = new ArrayList<Integer>();
            r.add(nums[i]);
            for(Integer t: l){
                r.add(t);
            }
            res.add(r);
            res.add(l);
        }

        return res;
    }
}