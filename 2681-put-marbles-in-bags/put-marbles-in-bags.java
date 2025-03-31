class Solution {
    public long putMarbles(int[] weights, int k) {
        int N = weights.length;

        int[] pairWeights = new int[N - 1];

        for(int i = 0; i < N - 1; i++){
            pairWeights[i] = weights[i] + weights[i + 1];
        }

        if(pairWeights.length == 1){
            return 0;
        }

        Arrays.sort(pairWeights, 0, N - 1);

        long ans = 0;

        for(int i = 0; i < k - 1; i++){
            ans += pairWeights[N - 2 - i] - pairWeights[i];
        }

        return ans;
    }
}