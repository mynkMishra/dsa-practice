class Solution {
    public int maximumBeauty(int[] nums, int k) {

        int limit = 100000;

        int[] prefix = new int[4*limit + 1];

        for(int el: nums){
            int min = el - k;
            int max = el + k;
            // System.out.println(el);
            prefix[min + limit + 1]++;
            prefix[max + limit + 2]--;
        }

        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i] + prefix[i - 1];
        }

        int ans = -1;
        for(int el: prefix){
            ans = Math.max(ans, el);
        }

        return ans;
    }
}