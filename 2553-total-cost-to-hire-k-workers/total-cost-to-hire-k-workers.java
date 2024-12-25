class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int N = costs.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int l = 0;
        while(l < candidates){
            pq.add(new int[]{costs[l], l});
            l++;
        }

        int r = N - 1;
        while(r >= N - candidates && r >= l){
            pq.add(new int[]{costs[r], r});
            r--;
        }

        long ans = 0;
        while(k > 0){

            int[] el = pq.poll();
            // System.out.println(el[0] + " " + el[1]);
            ans += (long)el[0];

            if(el[1] < l && l <= r){
                pq.add(new int[]{costs[l], l});
                l++;
            }

            if(el[1] > r && l <= r){
                pq.add(new int[]{costs[r], r});
                r--;
            }

            k--;
        }

        return ans;
    }
}