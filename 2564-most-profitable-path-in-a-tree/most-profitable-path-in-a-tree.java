class Solution {

    int ans = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        int N = edges.length;
        Map<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();

        for(int i = 0; i <= N; i++){
            tree.put(i, new ArrayList<Integer>());
        }

        for(int[] e: edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[N + 1];
        int[] pathB = new int[N + 1];
        pathB[0] = -1;

        dfsForBob(0, bob, pathB, visited, tree);

        Map<Integer, Integer> track = new HashMap<Integer, Integer>();

        int p = bob;
        int dist = 0;
        while(p != -1){
            track.put(p, dist);
            dist++;
            p = pathB[p];
        }

        visited = new boolean[N + 1];
        dfsForAlice(0, 0, amount[0], amount, track, visited, tree);

        return ans;
    }

    public void dfsForBob(
        int node, 
        int target, 
        int[] path, 
        boolean[] visited,
        Map<Integer, List<Integer>> tree
    ){
        
        if(node == target){
            return;
        }
        visited[node] = true;

        for(int n: tree.get(node)){
            if(!visited[n]){
                path[n] = node;
                dfsForBob(n, target, path, visited, tree);
            }
        }
    }

    public void dfsForAlice(
        int node, 
        int depth, 
        int total,
        int[] amount, 
        Map<Integer, Integer> track, 
        boolean[] visited,
        Map<Integer, List<Integer>> tree
    ){
        visited[node] = true;

        boolean flag = false;
        for(int n: tree.get(node)){
            if(!visited[n]){
                flag = true;
                if(track.get(n) != null){
                    if(track.get(n) == depth + 1){
                        dfsForAlice(n, depth + 1, total + amount[n]/2, amount, track, visited, tree);
                    }else if(track.get(n) < depth + 1){
                        dfsForAlice(n, depth + 1, total, amount, track, visited, tree);
                    }else{
                        dfsForAlice(n, depth + 1, total + amount[n], amount, track, visited, tree);
                    }
                }else{
                    dfsForAlice(n, depth + 1, total + amount[n], amount, track, visited, tree);
                }
            }
        }

        if(!flag){
            ans = Math.max(ans, total);
        }
    }
}