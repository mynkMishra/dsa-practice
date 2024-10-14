class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>(
            (Long a, Long b) -> (int)(b - a)
        );

        for(int i: nums){
            pq.add((long)i);
        }

        long sum = 0;
        while(k > 0){
            long val = (long)pq.poll();
            sum += val;
            pq.add((long)(Math.ceil((double)val/(double)3)));
            k--;
        }

        return sum;
    }
}