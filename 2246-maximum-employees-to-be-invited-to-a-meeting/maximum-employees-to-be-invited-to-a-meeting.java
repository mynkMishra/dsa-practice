class Solution {

    public int bfs(int curr, Set<Integer> visited, List<List<Integer>> graph){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{curr, 0});

        int maxDis = 0;

        while(queue.size() > 0){
            int[] el = queue.removeFirst();
            int u = el[0];
            int dist = el[1];

            for(int v: graph.get(u)){
                if(visited.contains(v)){
                    continue;
                }

                visited.add(v);
                queue.addLast(new int[]{v, dist + 1});
                maxDis = Math.max(maxDis, dist + 1);
            }
        }

        return maxDis;
    }
    public int maximumInvitations(int[] favorite) {
        int N = favorite.length;

        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < N; i++){
            int el = favorite[i];
            graph.get(el).add(i);
        }

        int longestCycle = 0;
        int twoCycleInv = 0;
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                Map<Integer, Integer> visitedPer = new HashMap<Integer, Integer>();
                int currPer = i;
                int dist = 0;
                while(true){
                    if(visited[currPer]){
                        break;
                    }

                    visited[currPer] = true;
                    visitedPer.put(currPer, dist);
                    dist++;

                    int nextPer = favorite[currPer];

                    if(visitedPer.containsKey(nextPer)){
                        int cycleLen = dist - visitedPer.get(nextPer);
                        longestCycle = Math.max(longestCycle, cycleLen);

                        if(cycleLen == 2){
                            Set<Integer> visNodes = new HashSet<>();
                            visNodes.add(currPer);
                            visNodes.add(nextPer);

                            twoCycleInv += 2 + bfs(nextPer, visNodes, graph) + bfs(currPer, visNodes, graph);
                        }

                        break;
                    }

                    currPer = nextPer;
                }
            }
        }

        return Math.max(longestCycle, twoCycleInv);
    }
}