class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        
        int l = 0;
        int r = queries.length;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(check(mid, nums, queries)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l > queries.length ? -1 : l;
    }

    public boolean check(int k, int[] nums, int[][] queries){

        int[] ps = new int[nums.length];

        for(int i = 0; i < k; i++){
            int q[] = queries[i];
            int l = q[0];
            int r = q[1];
            int v = q[2];

            ps[l] += v;
            if(r != ps.length - 1){
                ps[r + 1] -= v;
            } 
        }

        for(int i = 1; i < ps.length; i++){
            ps[i] += ps[i - 1];
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= ps[i]){
                count++;
            }
        }

        return count == nums.length;
    }
}