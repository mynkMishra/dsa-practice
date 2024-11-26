class Solution {
    public int findChampion(int n, int[][] edges) {

        if(edges.length == 0){
            if(n == 1){
                return 0;
            }else{
                return -1;
            }
        }

        int[] nodes = new int[n];

        for(int[] edge: edges){
            int v = edge[1];
            nodes[v]++;
        }

        int count = 0;
        int ans = -1;
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] == 0){
                count++;
                ans = i;
            }
        }

        if(count > 1){
            return -1;
        }

        return ans;
    }
}