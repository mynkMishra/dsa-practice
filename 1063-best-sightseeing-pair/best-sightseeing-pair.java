class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int N = values.length;
        int score = Integer.MIN_VALUE;
        ArrayList<int[]> stack = new ArrayList<int[]>();

        for(int i = N - 1; i >= 0; i--){
            int el = values[i];

            for(int j = 0; j < stack.size(); j++){
                int[] p = stack.get(j);
                score = Math.max(score, el + p[0] + i - p[1]);
            }

            if(stack.size() == 0){
                stack.add(new int[]{el, i});
            }else{
                while(stack.size() > 0 && el >= stack.get(stack.size() - 1)[0]){
                    stack.remove(stack.size() - 1);
                }

                stack.add(new int[]{el, i});
            }
        }

        return score;
    }
}