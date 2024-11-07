class Solution {
    public int largestCombination(int[] candidates) {
        
        int i = 0;
        int ans = -1;
        while(i < 31){
            int count = 0;
            for(int el: candidates){
                if((el & (1 << i)) > 0){
                    count++;
                }
            }
            ans = Math.max(ans, count);
            i++;
        }

        return ans;
    }
}