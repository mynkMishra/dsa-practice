class Solution {
    public void setZeroes(int[][] matrix) {
        
        int M = matrix.length;
        int N = matrix[0].length;

        boolean isCol = false;
        boolean isRow = false;

        for(int i = 0; i < M; i++){
            if(matrix[i][0] == 0){
                isCol = true;
            }
        }

        for(int j = 0; j < N; j++){
            if(matrix[0][j] == 0){
                isRow = true;
            }
        }
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(isRow){
            for(int j = 0; j < N; j++){
                matrix[0][j] = 0;
            }
        }

        if(isCol){
            for(int i = 0; i < M; i++){
                matrix[i][0] = 0;
            }
        }


    }
}
