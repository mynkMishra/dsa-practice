class Solution {

    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] pair: prerequisites){
            graph.get(pair[1]).add(pair[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(checkCycle(i, graph)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkCycle(int node, List<List<Integer>> graph){

        visited[node] = 1;

        boolean isCycle = false;
        for(int nb : graph.get(node)){
            if(visited[nb] == 1){
                return true;
            }
            
            if(visited[nb] == 0){
                isCycle = isCycle || checkCycle(nb, graph);
                if(isCycle){
                    return true;
                }
            }
        }
        visited[node] = 2;
        return isCycle;
    }


}