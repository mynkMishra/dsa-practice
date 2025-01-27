class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        boolean[][] isReachable = new boolean[numCourses + 1][numCourses + 1];

        for(int i = 0; i <= numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] pre: prerequisites){
            int u = pre[0];
            int v = pre[1];

            graph.get(u).add(v);
        }

        for(int i = 0; i < numCourses; i++){
            dfs(i, i, isReachable, graph);
        }

        List<Boolean> ans = new ArrayList<Boolean>();
        for(int[] q: queries){
            int u = q[0];
            int v = q[1];
            
            ans.add(isReachable[u][v]);
        }

        return ans;
    }

    public void dfs(int u, int parent, boolean[][] isReachable, ArrayList<ArrayList<Integer>> graph){
        
        if(isReachable[parent][u]){
            return;
        }

        isReachable[parent][u] = true;
        for(Integer v: graph.get(u)){
            dfs(v, parent, isReachable, graph);
        }
    }
}