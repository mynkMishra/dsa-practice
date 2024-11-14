class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = -1;

        for(int q: quantities){
            r = Math.max(r, q);
        }

        while(l<=r){
            int mid = l + (r - l)/2;

            if((mid == 1 || !isPossible(mid - 1, n, quantities)) && isPossible(mid, n, quantities)){
                return mid;
            }

            if(isPossible(mid, n, quantities)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }


        return 0;
    }

    public boolean isPossible(int min, int n, int[] quan){

        int count = 0;
        for(int i = 0; i < quan.length; i++){
            int v = quan[i]/min;

            count += quan[i]%min == 0 ? v : v + 1;
        }

        return count <= n;
    }
}