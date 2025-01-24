class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int N = graph.length;
        List<Integer> ans = new ArrayList<Integer>();
        boolean[] isSafe = new boolean[N];
        for(int i = 0; i < N; i++){
            if(dfs(i, new boolean[N], isSafe, graph)){
                isSafe[i] = true;
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean dfs(int u, boolean[] path, boolean[] isSafe, int[][] graph){

        if(path[u]){
            return false;
        }

        if(isSafe[u]){
            return true;
        }

        path[u] = true;

        boolean ans = true;
        for(int v: graph[u]){
            ans = ans && dfs(v, path, isSafe, graph);
            if(!ans){
                return false;
            }
        }
        if(ans){
            isSafe[u] = true;
        }
        path[u] = false;
        return ans;
    }
}