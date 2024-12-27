class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int N = values.length;
        int score = Integer.MIN_VALUE;
        int bestOption = Integer.MIN_VALUE;
        int idx = -1;

        for(int i = N - 1; i >= 0; i--){
            int el = values[i];

            score = Math.max(score, el + i + bestOption);

            if(bestOption < el - i){
                bestOption = el - i;
                idx = i;
            }
        }

        return score;
    }
}