class Solution {

    int ans = Integer.MIN_VALUE;
    public int longestSquareStreak(int[] nums) {
        
        Set<Integer> hs = new HashSet<Integer>();

        for(int e: nums){
            hs.add(e);
        }

        for(int i = 2; i < 350; i++){
            if(hs.contains(i)){
                solve(i, hs, 1);
            }
        }

        return ans < 2 ? -1 : ans;
    }

    public void solve(int el, Set<Integer> hs, int count){

        if(hs.contains(el*el)){
            solve(el*el, hs, count + 1);
        }

        ans = Math.max(ans, count);
    }
}