class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int el: banned){
            hm.put(el, 1);
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(hm.get(i) == null && maxSum - i >= 0){
                ans++;
                maxSum -= i;
            }
        }

        return ans;
    }
}