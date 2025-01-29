class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[N + 1];
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int start = dfs(edges[0][0], 0, visited, hm, graph);

        visited = new boolean[N + 1];

        int dest = hm.get(start);
        Map<Integer, Integer> cycle = new HashMap<Integer, Integer>();
        cycle.put(start, dest);

        while(dest != start){
            cycle.put(dest, hm.get(dest));
            dest = hm.get(dest);
        }
        
        int[] edge = new int[2];
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            if((cycle.get(u) != null && cycle.get(u) == v) || (cycle.get(v) != null && cycle.get(v) == u)){
                edge = e;
            }
        }
        return edge;
    }

    public int dfs(int u, int parent, boolean[] visited, Map<Integer, Integer> hm, ArrayList<ArrayList<Integer>> graph){

        hm.put(parent, u);
        if(visited[u]){
            return u;
        }

        visited[u] = true;

        int ans = -1;
        for(int v: graph.get(u)){
            if(v != parent){
                ans = dfs(v, u, visited, hm, graph);
                if(ans != -1){
                    return ans;
                }
            }
        }

        return ans;
    }
}