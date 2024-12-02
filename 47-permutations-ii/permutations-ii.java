class Solution {

    List<List<Integer>> ans;
    boolean[] visited;
    Map<String, Integer> hm;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        visited = new boolean[nums.length];
        hm = new HashMap<String, Integer>();

        solve(0, new ArrayList<Integer>(), "", nums);
        return ans;
    }

    public void solve(int idx, List<Integer> list, String str, int[] nums){

        if(list.size() == nums.length && hm.get(str) == null){
            hm.put(str, 1);
            List<Integer> l = new ArrayList<Integer>();
            for(Integer el: list){
                l.add(el);
            }
            ans.add(l);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){            
                visited[i] = true;
                list.add(nums[i]);
                solve(i + 1, list, str + "" + nums[i], nums);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}