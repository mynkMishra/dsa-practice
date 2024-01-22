class Solution {
    class Node{
        int el;
        int step;

        Node(int el, int step){
            this.el = el;
            this.step = step;
        }
    }
    public int[] countOfPairs(int n, int x, int y) {
        List<List<Integer>> map = new ArrayList<List<Integer>>();

        for(int i = 0; i <= n; i++){
            map.add(new ArrayList<Integer>());
        }

        for(int i = 1; i <= n - 1; i++){
            map.get(i).add(i + 1);
            map.get(i + 1).add(i);
        }

        map.get(x).add(y);
        map.get(y).add(x);

        int[] ans = new int[n];
        for(int i = 1; i <= n; i++){
            int[] dist = runBfs(i, n, map);
            for(int d = 0; d < dist.length; d++){
                if(d + 1 != i){
                    ans[dist[d] - 1]++;
                }
            }
        }

        return ans;
    }

    public int[] runBfs(int el, int n, List<List<Integer>> map){
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(new Node(el, 0));

        while(queue.size() > 0){
            Node node = queue.removeFirst();

            if(visited[node.el - 1]){
                continue;
            }

            visited[node.el - 1] = true;
            for(Integer neighbour: map.get(node.el)){
                if(!visited[neighbour - 1] && node.step + 1 < dist[neighbour - 1]){
                    dist[neighbour - 1] = node.step + 1;
                    queue.addLast(new Node(neighbour, node.step + 1));
                }
            }
        }

        return dist;
    }
}