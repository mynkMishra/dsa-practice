class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        int Q = queries.length;
        int[] ans = new int[Q];

        Map<Integer, Integer> ballColorMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> colorFreqMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < Q; i++){
            int ball = queries[i][0];
            int color = queries[i][1];

            if(ballColorMap.get(ball) == null){
                ballColorMap.put(ball, color);
                colorFreqMap.put(color, colorFreqMap.getOrDefault(color, 0) + 1);
                ans[i] = colorFreqMap.size();
            }else{
                int existingColor = ballColorMap.get(ball);
                colorFreqMap.put(existingColor, colorFreqMap.get(existingColor) - 1);
                if(colorFreqMap.get(existingColor) == 0){
                    colorFreqMap.remove(existingColor);
                }

                ballColorMap.put(ball, color);
                colorFreqMap.put(color, colorFreqMap.getOrDefault(color, 0) + 1);
                ans[i] = colorFreqMap.size();
            }
        }

        return ans;
    }
}