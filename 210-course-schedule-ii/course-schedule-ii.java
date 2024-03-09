class Solution {

    int[] visited;
    ArrayList<Integer> result;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i = 0 ;i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] pair: prerequisites){
            graph.get(pair[1]).add(pair[0]);
        }

        visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0 && checkCycle(i, graph)){
                return new int[0];
            }
        }

        visited = new int[numCourses];
        result = new ArrayList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                dfs(i, graph);
            }
        }

        int[] path = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            path[i] = result.get(result.size() - i - 1);
        }
        return path;
    }

    public boolean checkCycle(int node, List<List<Integer>> graph){

        visited[node] = 1;
        boolean isCycle = false;
        for(int nb: graph.get(node)){
            if(visited[nb] == 1){
                return true;
            }

            if(visited[nb] == 0){
                isCycle = isCycle || checkCycle(nb, graph);
            }
        }

        visited[node] = 2;
        return isCycle;
    }

    public void dfs(int node, List<List<Integer>> graph){

        visited[node] = 1;

        for(int el: graph.get(node)){
            if(visited[el] == 0){
                dfs(el, graph);
            }
        }

        result.add(node);
    }
}