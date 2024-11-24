class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        int N = matrix.length;
        int M = matrix[0].length;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int absMin = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(matrix[i][j] < 0){
                    if(min > Math.abs(matrix[i][j])){
                        min = Math.abs(matrix[i][j]);
                    }
                    count++;
                }else {
                    if(absMin > matrix[i][j]){
                        absMin = matrix[i][j];
                    }
                }
            }
        }

        long ans = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                ans += Math.abs(matrix[i][j]);
            }
        }

        if(count%2 == 0){
            return ans;
        }else{
            return ans - 2*Math.min(min, absMin);
        }

    }
}