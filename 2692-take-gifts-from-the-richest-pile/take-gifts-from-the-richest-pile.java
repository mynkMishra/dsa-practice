class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((Integer a, Integer b) -> (int)b - (int)a);
        
        for(int el: gifts){
            pq.add(el);
        }

        while(k > 0){
            Integer g = (int)pq.peek();

            if(g == 1){
                break;
            }

            g = (int)pq.poll();
            int t = (int)Math.floor(Math.sqrt(g));
            pq.add(t);

            k--;
        }

        long ans = 0;
        while(pq.size() > 0){
            ans += (long)pq.poll();
        }

        return ans;
    }
}