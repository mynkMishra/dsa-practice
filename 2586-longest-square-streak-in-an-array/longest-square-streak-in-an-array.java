class Solution {

    int ans = Integer.MIN_VALUE;
    public int longestSquareStreak(int[] nums) {
        
        Set<Integer> hs = new HashSet<Integer>();

        for(int e: nums){
            hs.add(e);
        }

        for(int i = 2; i < 350; i++){
            int el = i;
            int count = 0;
            while(hs.contains(el)){
                count++;
                el = el*el;
                ans = Math.max(ans, count);
            }
        }

        return ans < 2 ? -1 : ans;
    }
}