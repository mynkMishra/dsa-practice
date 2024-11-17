class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int N = nums.length;

        long sum = 0;
        int ans = Integer.MAX_VALUE;
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<Pair<Long, Integer>>(
            (a, b) -> Long.compare(a.getKey(), b.getKey())
        );

        for(int i = 0; i < N; i++){
            sum += (long)nums[i];

            if(sum >= k){
                ans = Math.min(ans, i + 1);
            }

            while(pq.size() != 0 && sum - pq.peek().getKey() >= k){
                ans = Math.min(ans, i - pq.poll().getValue());
            }

            pq.offer(new Pair<Long, Integer>(sum, i));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}