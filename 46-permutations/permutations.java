class Solution {

    List<Integer> list;
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<Integer>();
        ans = new ArrayList<List<Integer>>();

        int mask = 0;
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
            solve(i, (mask | (1 << i)), nums);
            list.remove(list.size() - 1);
        }

        return ans;
    }

    public void solve(int idx, int mask, int[] nums){

        if(list.size() == nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        
        for(int i = 0; i < nums.length; i++){
            if((mask & (1 << i)) == 0){
                list.add(nums[i]);
                solve(i, (mask | (1 << i)), nums);
                list.remove(list.size() - 1);
            }
        }
    }
}