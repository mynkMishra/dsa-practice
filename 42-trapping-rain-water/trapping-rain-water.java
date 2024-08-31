class Solution {
    public int trap(int[] A) {

        int N = A.length;
        int[] left_max = new int[N];
        int[] right_max = new int[N];

        int max = -1;
        for(int i = 0; i < N; i++){
            left_max[i] = max;
            max = Math.max(max, A[i]);
        }

        max = -1;
        for(int i = N - 1; i >= 0; i--){
            right_max[i] = max;
            max = Math.max(max, A[i]);
        }

        int total = 0;
        for(int i = 0; i < N; i++){
            int vol = Math.min(left_max[i], right_max[i]) - A[i];

            if(vol > 0){
                total += vol;
            }
        }

        return total;
    }
}