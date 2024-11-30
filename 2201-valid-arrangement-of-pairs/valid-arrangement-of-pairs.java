class Solution {

    ArrayList<Integer> sb = new ArrayList<Integer>();
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        Map<Integer, Integer> indgree = new HashMap<Integer, Integer>();
        Map<Integer, Integer> outdgree = new HashMap<Integer, Integer>();

        for(int[] p: pairs){

            int u = p[0];
            int v = p[1];
            if(graph.get(u) == null){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(v);
                graph.put(u, list);
            }else{
                graph.get(u).add(v);
            }

            outdgree.put(u, outdgree.getOrDefault(u, 0) + 1);
            indgree.put(v, indgree.getOrDefault(v, 0) + 1);
        }

        int start = -1;
        for(Integer u : outdgree.keySet()){
            if(outdgree.getOrDefault(u, 0) - indgree.getOrDefault(u, 0) == 1){
                start = u;
                break;
            }
        }

        if(start == -1){
            start = pairs[0][0];
        }

        solve(start, graph);
        System.out.println(sb.toString());
        int[][] ans = new int[sb.size() - 1][2];
        
        Collections.reverse(sb);
        for(int i = 1; i < sb.size(); i++){
            ans[i - 1] = new int[]{sb.get(i - 1), sb.get(i)};
        }

        return ans;
    }

    public void solve(int u, Map<Integer, ArrayList<Integer>> graph){

        ArrayList<Integer> list = graph.get(u);
        while(list != null && list.size() > 0){
            Integer v = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            solve(v, graph);
        }
        sb.add(u);
    }
}