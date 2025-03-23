class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000000 + 7;
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<int[]>());
        }

        for(int[] r: roads){
            int u = r[0];
            int v = r[1];
            int w = r[2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        long[] cost = new long[n];
        int[] pathCount = new int[n];
        pathCount[0] = 1;
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[0] = 0;

        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> (int)(a[1] - b[1]));
        queue.add(new long[]{0, 0});

        Map<Long, Long> freq = new HashMap<>();

        while(queue.size() > 0){
            long[] el = queue.poll();
            int currNode = (int)el[0];
            long currTime = el[1];

            if(currTime > cost[currNode]){
                continue;
            }

            for(int[] nb: graph.get(currNode)){
                if(cost[nb[0]] > currTime + nb[1]){
                    cost[nb[0]] = currTime + nb[1];
                    pathCount[nb[0]] = pathCount[currNode];
                    queue.add(new long[]{nb[0], (int)(cost[nb[0]])});
                }else if(cost[nb[0]] == currTime + nb[1]){
                    pathCount[nb[0]] = (pathCount[currNode] + pathCount[nb[0]])%mod;
                }
            }
        }

        return pathCount[n - 1];
    }
}