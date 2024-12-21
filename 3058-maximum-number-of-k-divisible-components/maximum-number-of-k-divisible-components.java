class Solution {

    int componentCount = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        for(int i = 0; i < values.length; i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1, adjList, values, k);
        return componentCount;
    }

    public int dfs(int currentNode, int parentNode, List<List<Integer>> adjList, int[] values, int k){

        int sum = 0;

        for(int nNode: adjList.get(currentNode)){
            if(nNode != parentNode){
                sum += dfs(nNode, currentNode, adjList, values, k);
                sum = sum%k;
            }
        }

        sum += values[currentNode];
        sum = sum%k;
        if(sum == 0){
            componentCount++;
        }

        return sum;
    }
}