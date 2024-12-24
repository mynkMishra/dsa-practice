class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

        int N = edges1.length;
        List<List<Integer>> adjListN = new ArrayList<List<Integer>>();
        prepareAdjacencyList(edges1, adjListN);

        int M = edges2.length;
        List<List<Integer>> adjListM = new ArrayList<List<Integer>>();
        prepareAdjacencyList(edges2, adjListM);

        int diameterN = N == 0 ? 0 : findDiameter(N, adjListN);
        int diameterM = M == 0 ? 0 : findDiameter(M, adjListM);

        // System.out.println(diameterN + " " + diameterM);
        int minN = (diameterN & 1) == 0 ? diameterN/2 : (diameterN + 1)/2;
        int minM = (diameterM & 1) == 0 ? diameterM/2 : (diameterM + 1)/2;
        int newDiameter = minN + minM + 1;

        return Math.max(newDiameter, Math.max(diameterN, diameterM));
    }

    public int findDiameter(int N, List<List<Integer>> adjList){
        int[] dist = new int[N + 1];
        dist[0] = 0;

        boolean[] visited = new boolean[N + 1];
        visited[0] = true;
        findNodeDistFrom(0, visited, dist, adjList);
        int maxDist = -1;
        int node = -1;
        for(int i = 0; i <= N; i++){
            if(maxDist < dist[i]){
                maxDist = dist[i];
                node = i;
            }
        }

        dist = new int[N + 1];
        dist[node] = 0;

        visited = new boolean[N + 1];
        visited[node] = true;
        findNodeDistFrom(node, visited, dist, adjList);
        int diameter = Integer.MIN_VALUE;

        // System.out.println(N);
        for(int i = 0; i <= N; i++){
            int el = dist[i];
            // System.out.println(i + " " + el);
            diameter = Math.max(diameter, el);
        }

        return diameter;
    }

    public void findNodeDistFrom(int node, boolean[] visited, int[] dist, List<List<Integer>> adjList){

        for(int nNode: adjList.get(node)){
            if(!visited[nNode]){
                visited[nNode] = true;
                dist[nNode] = dist[node] + 1;
                findNodeDistFrom(nNode, visited, dist, adjList);
            }
        }
    }

    public void prepareAdjacencyList(int[][] edges, List<List<Integer>> adjList){
        int N = edges.length;
        
        for(int i = 0; i <= N; i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }
}