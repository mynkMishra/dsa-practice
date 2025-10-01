class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int ans = numBottles;
        while(numBottles >= numExchange){
            int empty = (numBottles/numExchange) + (numBottles%numExchange);
            ans += numBottles/numExchange;
            numBottles = empty;
        }

        return ans;
    }
}