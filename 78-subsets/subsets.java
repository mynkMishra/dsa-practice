class Solution {

    List<Integer> list;
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<Integer>();
        ans = new ArrayList<List<Integer>>();

        ans.add(new ArrayList<Integer>(list));
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
            solve(i, nums);
            list.remove(list.size() - 1);
        }
        
        return ans;
    }

    public void solve(int idx, int[] nums){

        ans.add(new ArrayList<Integer>(list));
        if(idx == nums.length){
            return;
        }

        for(int i = idx + 1; i < nums.length; i++){
            list.add(nums[i]);
            solve(i, nums);
            list.remove(list.size() - 1);
        }
        
    }
}