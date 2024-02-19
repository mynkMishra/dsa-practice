class Solution {
    public boolean isPowerOfTwo(int n) {
        int l = -1;
        int r = 32;

        while(l + 1 < r){
            int mid = l + (r - l)/2;
            if(((int)Math.pow(2, mid)) < n){
                l = mid;
            }else{
                r = mid;
            }
        }

        // System.out.println(r + " " + (long)Math.pow(2, r));
        return ((long)Math.pow(2, r)) == n;
    }
}