class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        Map<Integer, Integer> numToGroup = new HashMap<Integer, Integer>();
        Map<Integer, ArrayList<Integer>> groupToList = new HashMap<Integer, ArrayList<Integer>>();

        Integer[] arr = new Integer[nums.length];

        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a, b));

        int g = 0;
        numToGroup.put(arr[0], g);
        groupToList.put(0, new ArrayList<Integer>());
        groupToList.get(0).add(arr[0]);
        for(int i = 1; i < nums.length; i++){
            if(Math.abs(arr[i - 1] - arr[i]) <= limit){
                numToGroup.put(arr[i], g);
            }else{
                g++;
                numToGroup.put(arr[i], g);
            }

            if(groupToList.get(g) == null){
                groupToList.put(g, new ArrayList<Integer>());
            }
            groupToList.get(g).add(arr[i]);
        }

        for(ArrayList<Integer> l: groupToList.values()){
            Collections.sort(l);
        }

        for(int i = 0; i < nums.length; i++){
            int group = numToGroup.get(nums[i]);
            int el = groupToList.get(group).remove(0);
            nums[i] = el;
        }
        
        return nums;
    }
}