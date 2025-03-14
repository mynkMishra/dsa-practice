class Solution {
    public int maximumCandies(int[] candies, long k) {
        int l = 1;
        int r = 0;

        long sum = 0;
        for(int c: candies){
            sum += (long)(c);
            r = Math.max(r, c);
        }

        if(sum < k){
            return 0;
        }

        while(l <= r){
            int mid = l + (r - l)/2;

            if(check(mid, candies, k)){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean check(int maxC, int[] candies, long k){

        for(int i = 0; i < candies.length; i++){
            if(candies[i] >= maxC){
                int c = candies[i]/maxC;
                k -= c;
            }

            if(k <= 0){
                return true;
            }
        }

        return false;
    }
}