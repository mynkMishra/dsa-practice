class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
        ArrayList<int[]> interval = new ArrayList<int[]>();

        int st = 0;
        int end = 0;
        for(int i = 1; i < nums.length; i++){
            if((nums[i - 1]%2 == 0 && nums[i]%2 == 1) || nums[i - 1]%2 == 1 && nums[i]%2 == 0){
                end = i;
            }else {
                int[] res = new int[2];
                res[0] = st;
                res[1] = end;
                interval.add(res);
                st = i;
                end = i;
            }
        }
        int[] res = new int[2];
        res[0] = st;
        res[1] = end;
        interval.add(res);

        int i = 0;
        boolean[] ans = new boolean[queries.length];
        for(int[] q: queries){
            // int st = q[0];
            // int end = q[1];

            int idx = find(q, interval);
            ans[i] = idx != -1;
            i++;
        }

        return ans;
    }

    public int find(int[] range, ArrayList<int[]> interval){

        int st = range[0];
        int end = range[1];

        int l = 0;
        int r = interval.size() - 1;

        while(l<=r){
            int mid = l + (r - l)/2;

            if(interval.get(mid)[0] < st && interval.get(mid)[1] < st){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        if(l < interval.size() && interval.get(l)[0] <= st && end <= interval.get(l)[1]){
            return l;
        }

        return -1;
    }
}