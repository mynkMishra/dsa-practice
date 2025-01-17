class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int ans = 0;
        for(int el: derived){
            ans = (ans ^ el);
        }

        return ans == 0;
    }
}