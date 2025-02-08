class Solution {

    int total;
    long res = -1; 
    Map<Long, Integer> scoreMap;

    public int countHighestScoreNodes(int[] parents) {
        total = parents.length;
        scoreMap = new HashMap<Long, Integer>();

        Map<Integer, ArrayList<Integer>> tree = new HashMap<Integer, ArrayList<Integer>>();

        for(int i = 0; i < total; i++){
            tree.put(i, new ArrayList<Integer>());
        }

        for(int i = 1; i < total; i++){
            int el = i;
            int p = parents[i];

            tree.get(p).add(el);
        }

        solve(0, tree);

        return scoreMap.get(res);
    }

    public long solve(int n, Map<Integer, ArrayList<Integer>> tree){
        
        List<Long> ans = new ArrayList<Long>();

        for(int v: tree.get(n)){
            ans.add(solve(v, tree));
        }

        long mul = 1;
        long sum = 0;
        for(long el: ans){
            mul *= el;
            sum += el;
        }

        
        if(n != 0){
            if(ans.size() == 0){
                mul *= (total - 1);
            }else{
                mul *= (total - sum - 1);
            }
        }

        scoreMap.put(mul, scoreMap.getOrDefault(mul, 0) + 1);

        res = Math.max(res, mul);

        return sum + 1;
    }
}