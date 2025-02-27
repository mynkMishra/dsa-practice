class Solution {

    int res = Integer.MIN_VALUE;
    int[][] dp;
    Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

    public int lenLongestFibSubseq(int[] arr) {
        
        int N = arr.length;
        dp = new int[N + 1][N + 1];

        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        for(int i = 0; i < arr.length; i++){
            hm.put(arr[i], i);
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(hm.get(arr[i] + arr[j]) != null){
                    res = Math.max(res, solve(i, j, arr));
                }
            }
        }

        return res == Integer.MIN_VALUE ? 0 : res + 2;
    }

    public int solve(int idx1, int idx2, int[] arr){
        
        if(hm.get(arr[idx1] + arr[idx2]) == null){
            return 0;
        }

        int nextIdx = hm.get(arr[idx1] + arr[idx2]);
        int res = solve(idx2, nextIdx, arr) + 1;

        return res;
    }
}