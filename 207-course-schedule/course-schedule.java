class Solution {

    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] p: prerequisites){
            int a = p[0];
            int b = p[1];

            adj.get(b).add(a);
        }

        visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0 && isCycle(i, adj)){
                return false;
            }
        }

        return true;
    }

    public boolean isCycle(int node, ArrayList<ArrayList<Integer>> adj){

        visited[node] = 1;

        boolean flag = false;
        for(int nb: adj.get(node)){
            if(visited[nb] == 1){
                return true;
            }

            if(visited[nb] == 0){
                flag = flag || isCycle(nb, adj);
                if(flag){
                    return true;
                }
            }
        }

        visited[node] = 2;
        return false;
    }
}