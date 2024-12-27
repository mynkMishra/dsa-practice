class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int N = values.length;
        ArrayList<int[]> stack = new ArrayList<int[]>();
        ArrayList<ArrayList<int[]>> aux = new ArrayList<ArrayList<int[]>>();

        for(int i = 0; i < N; i++){
            aux.add(new ArrayList<int[]>());
        }

        for(int i = N - 1; i >= 0; i--){
            int el = values[i];

            for(int j = 0; j < stack.size(); j++){
                aux.get(i).add(stack.get(j));
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

        int score = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            int el = values[i];
            for(int[] p: aux.get(i)){
                score = Math.max(score, el + p[0] + i - p[1]);
            }
        }

        return score;
    }
}