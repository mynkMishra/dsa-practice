class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        
        int N = arr.length;
        int r = N - 1;

        while(r > 0 && arr[r - 1] <= arr[r]){
            r--;
        }

        if(r == 0){
            return 0;
        }

        int ans = r;
        int l = 0;
        while(l < r && (l == 0 || arr[l - 1] <= arr[l])){
            while(r < N && arr[l] > arr[r]){
                r++;
            }
            ans = Math.min(ans, r - l - 1);
            l++;
        }

        return ans;
    }
}