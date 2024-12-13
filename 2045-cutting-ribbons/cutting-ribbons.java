class Solution {
    public int maxLength(int[] ribbons, int k) {
        int N = ribbons.length;

        int l = 1;
        int r = Integer.MAX_VALUE;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(getSegmentCount(mid, ribbons) >= k){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return r;
    }

    public int getSegmentCount(int len, int[] ribbons){

        int count = 0;
        for(int el: ribbons){
            if(el >= len){
                count += el/len;
            } 
        }
        return count;
    }
}