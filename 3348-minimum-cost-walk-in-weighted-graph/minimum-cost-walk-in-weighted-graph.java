class Solution {

    class Edge{
        int node;
        int wt;

        Edge(int n, int w){
            this.node = n;
            this.wt = w;
        }
    }

    Map<Integer, Integer> pHm = new HashMap<Integer, Integer>();
    Map<Integer, Integer> pScore = new HashMap<Integer, Integer>();
    int ans = Integer.MAX_VALUE;
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<List<Edge>> adjList = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adjList.get(u).add(new Edge(v, w));
            adjList.get(v).add(new Edge(u, w));
        }

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            List<Integer> cost = new ArrayList<Integer>();
            if(!visited[i]){
                dfs(i, i, cost, visited, adjList);
            }

            int val = cost.size() == 0 ? -1 : cost.get(0);
            for(int j = 1; j < cost.size(); j++){
                val = (val & cost.get(j));
            }
            pScore.put(i, val);
        }

        int[] res = new int[query.length];

        for(int i = 0; i < query.length; i++){
            int[] q = query[i];
            int s = q[0];
            int t = q[1];

            int p1 = pHm.get(s);
            int p2 = pHm.get(t);

            if(p1 == p2){
                res[i] = pScore.get(p1);
            }else{
                res[i] = -1;
            }
        }

        return res;
    }

    public void dfs(int u, int parent, List<Integer> cost, boolean[] visited, List<List<Edge>> adjList){

        pHm.put(u, parent);
        for(Edge nb: adjList.get(u)){
            cost.add(nb.wt);
            if(!visited[nb.node]){
                visited[nb.node] = true;
                dfs(nb.node, parent, cost, visited, adjList);
            }
        }
    }
}