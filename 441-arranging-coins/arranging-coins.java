class Solution {
    public int arrangeCoins(int n) {
        
        long l = 0;
        long r = (long)n;

        while(l<=r){
            long mid = l + (r - l)/2;

            long coins = mid*(mid + 1)/2;

            if(coins == n){
                return (int)mid;
            }

            if(coins < n){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return (int)l - 1;
    }
}