class Solution {
    public int maxTwoEvents(int[][] events) {
        
        int maxVal = 0;
        int sum = 0;

        PriorityQueue<Pair<Integer, Integer>> pq = 
            new PriorityQueue<Pair<Integer, Integer>>(
                (Pair<Integer, Integer> a, Pair<Integer, Integer> b) -> a.getKey() - b.getKey());

        Arrays.sort(events, (int[] a, int[] b) -> a[0] - b[0]);

        for(int[] ev: events){

            while(!pq.isEmpty() && pq.peek().getKey() < ev[0]){
                Pair p = pq.poll();
                maxVal = Math.max((int)p.getValue(), maxVal);
            }

            sum = Math.max(sum, maxVal + ev[2]);
            int endTime = ev[1];
            int value = ev[2];
            pq.add(new Pair<Integer, Integer>(endTime, value));
        }

        return sum;


    }
}