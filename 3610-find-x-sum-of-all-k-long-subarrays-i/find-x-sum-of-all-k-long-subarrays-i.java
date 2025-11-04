class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(j < nums.length){

            int val = nums[j];
            hm.put(val, hm.getOrDefault(val, 0) + 1);

            if(j >= k){
                int v = nums[i];
                hm.put(v, hm.getOrDefault(v, 0) - 1);
                i++;
            }
            j++;

            if(j - i >= k){
                ans.add(calculateSum(hm, x));
            }
        }

        return ans.stream().mapToInt(t -> t).toArray();
    }

    public int calculateSum(Map<Integer, Integer> hm, int x){
        PriorityQueue<int[]> minH = new PriorityQueue<int[]>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for(Map.Entry<Integer, Integer> e: hm.entrySet()){
            minH.add(new int[]{e.getKey(), e.getValue()});
            if(minH.size() > x){
                minH.poll();
            }
        }

        int ans = 0;
        while(minH.size() > 0){
            int[] v = minH.poll();
            ans += v[0]*v[1];
        }

        return ans;
    }
}