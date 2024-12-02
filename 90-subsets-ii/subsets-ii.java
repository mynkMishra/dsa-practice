class Solution {

    List<Integer> list;
    List<List<Integer>> ans;
    Map<String, Integer> hm;
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        list = new ArrayList<Integer>();
        ans = new ArrayList<List<Integer>>();
        hm = new HashMap<String, Integer>();

        // for(int i = 0; i < nums.length; i++){
        //     if(hm.get("" + nums[i]) == null){
        //         hm.put("" + nums[i], 1);
        //         list.add(nums[i]);
        //         solve(i, "" + nums[i], nums);
        //         list.remove(list.size() - 1);
        //         // hm.remove("" + nums[i]);
        //     }
        // }
        solve(-1, "", nums);

        return ans;
    }

    public void solve(int idx, String mask, int[] nums){

        if(idx == nums.length){
            return;
        }

        ans.add(new ArrayList<Integer>(list));
        for(int i = idx + 1; i < nums.length; i++){
            if(hm.get(mask + "" + nums[i]) == null){
                hm.put(mask + "" + nums[i], 1);
                list.add(nums[i]);
                solve(i, mask + "" + nums[i], nums);
                list.remove(list.size() - 1);
                // hm.remove(mask + "" + nums[i]);
            }
        }
    }
}