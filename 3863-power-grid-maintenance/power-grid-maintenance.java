class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        ArrayList<ArrayList<Integer>> adjL = new ArrayList<>();

        for(int i = 0; i <= c; i++){
            adjL.add(new ArrayList<Integer>());
        }

        for(int[] con: connections){
            int u = con[0];
            int v = con[1];

            adjL.get(u).add(v);
            adjL.get(v).add(u);
        }

        boolean[] visited = new boolean[c + 1];
        int idx = 0;
        ArrayList<TreeSet<Integer>> grids = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 1; i <= c; i++){
            if(!visited[i]){
                TreeSet<Integer> ts = new TreeSet<>((a, b) -> a - b);
                dfs(i, adjL, visited, ts, idx, hm);
                grids.add(ts);
                idx++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int[] q: queries){
            if(q[0] == 1){
                int st = q[1];
                int i = hm.get(st);
                if(grids.get(i).contains(st)){
                    list.add(st);
                }else{
                    if(grids.get(i).size() > 0){
                        list.add(grids.get(i).first());
                    }else{
                        list.add(-1);
                    }
                }
            }else{
                int st = q[1];
                int i = hm.get(st);
                grids.get(i).remove(st);
            }
        }

        return list.stream().mapToInt(t -> t).toArray();

    }

    public void dfs(int n, ArrayList<ArrayList<Integer>> adjL, boolean[] visited, TreeSet<Integer> ts, int idx, Map<Integer, Integer> hm){

        for(Integer nb: adjL.get(n)){
            if(!visited[nb]){
                visited[nb] = true;
                dfs(nb, adjL, visited, ts, idx, hm);
            }
        }

        ts.add(n);
        hm.put(n, idx);
    }
}