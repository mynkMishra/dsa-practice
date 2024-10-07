class Solution {
    public boolean isPerfectSquare(int num) {
        
        long l = 1;
        long r = (long)Math.pow(2, 17);

        while(l<=r){
            long mid = l + (r - l)/2;

            if(mid*mid == num){
                return true;
            }

            if(mid*mid < num){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return false;
    }
}