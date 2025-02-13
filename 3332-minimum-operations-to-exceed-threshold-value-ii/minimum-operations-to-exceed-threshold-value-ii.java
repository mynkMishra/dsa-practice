class Solution {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        for(int e: nums){
            pq.add((long)e);
        }

        int count = 0;
        while(pq.peek() < k && pq.size() >= 2){
            long x = pq.poll();
            long y = pq.poll();

            count++;

            long r = Math.min(x, y)*2 + Math.max(x, y);
            pq.add(r);
        }

        return count;
    }
}