class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] ans = new int[n];

        if(k == 0){
            Arrays.fill(ans, 1);
            return ans;
        }
        
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            adj1.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges1){
            int u = edge[0];
            int v = edge[1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }

        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < m; i++){
            adj2.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges2){
            int u = edge[0];
            int v = edge[1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }

        int[] aux1 = new int[n];

        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            visited[i] = true;
            aux1[i] = dfs(i, k, visited, adj1);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            boolean[] visited = new boolean[m];
            visited[i] = true;
            int t = dfs(i, k - 1, visited, adj2);
            max = Math.max(max, t);
        }

        for(int i = 0; i < n; i++){
            ans[i] = aux1[i] + max;
        }

        return ans;
    }

    public int dfs(int n, int k, boolean[] visited, ArrayList<ArrayList<Integer>> adj){

        if(k < 0){
            return 0;
        }
        
        if(k == 0){
            return 1;
        }

        int sum = 0;
        for(int t: adj.get(n)){
            if(!visited[t]){
                visited[t] = true;
                sum += dfs(t, k - 1, visited, adj);
            }
        }

        return sum + 1;
    }
}