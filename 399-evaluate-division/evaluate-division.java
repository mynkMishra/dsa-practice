class Solution {

        Map<String, Map<String, Double>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        for(int i = 0; i < equations.size(); i++){
            List<String> eq = equations.get(i);
            double val = values[i];

            graph.putIfAbsent(eq.get(0), new HashMap<>());
            graph.get(eq.get(0)).put(eq.get(1), val);

            graph.putIfAbsent(eq.get(1), new HashMap<>());
            graph.get(eq.get(1)).put(eq.get(0), 1/val);
        }

        double[] ans = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }

        return ans;
    }

    public double dfs(String start, String end, Set<String> visited){

            if(!graph.containsKey(start)){
                return -1.0;
            }

            if(graph.get(start).containsKey(end)){
                return graph.get(start).get(end);
            }

            visited.add(start);
            for(String n: graph.get(start).keySet()){
                if(!visited.contains(n)){
                    double val = dfs(n, end, visited);
                    if(val != -1.0){
                        return val*graph.get(start).get(n);
                    }
                }
            }

            return -1.0;
    }
}