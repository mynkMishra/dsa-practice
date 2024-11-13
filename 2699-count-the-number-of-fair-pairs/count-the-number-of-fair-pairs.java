class Solution {

    int N;
    public long countFairPairs(int[] nums, int lower, int upper) {

        N = nums.length;
        Arrays.sort(nums);

        long ans = 0;
        for(int i = 0; i < N; i++){
            int el = nums[i];
            int li = find(lower - el, i+ 1, nums);
            int ui = find(upper + 1 - el, i + 1, nums);
            ans += (ui - li);
        }

        return ans;
    }

    public int find(int el, int start, int[] nums){

        int l = start;
        int r = nums.length - 1;

        while(l<=r){
            int mid = l + (r - l)/2;

            if(el <= nums[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

}