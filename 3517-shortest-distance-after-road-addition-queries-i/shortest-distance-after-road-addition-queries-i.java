class Solution {

    List<List<Integer>> graph = new ArrayList<List<Integer>>();
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        for(int i = 0; i < n - 1; i++){
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(i + 1);
            graph.add(l);
        }

        bfs(n);
        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int[] q = queries[i];
            int u = q[0];
            int v = q[1];
            graph.get(u).add(v);
            ans[i] = bfs(n);
        }

        return ans;
    }

    public int bfs(int n){
        boolean[] visited = new boolean[n];
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();

        queue.add(new Pair<Integer, Integer>(0, 0));

        while(queue.size() > 0){
            Pair<Integer, Integer> p = queue.poll();

            if(p.getKey() == n - 1){
                return p.getValue();
            }

            for(Integer el : graph.get(p.getKey())){
                if(!visited[el]){
                    visited[el] = true;
                    queue.add(new Pair(el, p.getValue() + 1));
                }
            }
        }

        return -1;
    }
}