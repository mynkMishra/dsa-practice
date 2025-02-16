class Solution {

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2*n - 1];
        boolean[] visited = new boolean[n + 1];

        solve(0, res, visited, n);

        return res;
    }

    public boolean solve(int idx, int[] res, boolean[] visited, int targetNumber){
        if(idx == res.length){
            return true;
        }

        if(res[idx] != 0){
            return solve(idx + 1, res, visited, targetNumber);
        }

        for(int i = targetNumber; i >= 1; i--){
            if(visited[i]){
                continue;
            }

            res[idx] = i;
            visited[i] = true;

            if(i == 1){
                if(solve(idx + 1, res, visited, targetNumber)){
                    return true;
                }
            }else if(idx + i < res.length && res[idx + i] == 0){
                res[idx + i] = i;

                if(solve(idx + 1, res, visited, targetNumber)){
                    return true;
                }

                res[idx + i] = 0;
            }

            res[idx] = 0;
            visited[i] = false;
        }

        return false;
    }
}