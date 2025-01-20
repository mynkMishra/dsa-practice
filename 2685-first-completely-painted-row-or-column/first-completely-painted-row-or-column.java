class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;
        int[][] location = new int[N*M + 1][2];
        int[][] aux = new int[N + 1][M + 1];

        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = 0; j < M; j ++){
                sum += mat[i][j];
                aux[i][j] = mat[i][j];
                location[mat[i][j]] = new int[]{i, j};
            }
            aux[i][M] = sum;
        }

        for(int j = 0; j < M; j++){
            int sum = 0;
            for(int i = 0; i < N; i++){
                sum += mat[i][j];
            }
            aux[N][j] = sum;
        }

        for(int i = 0; i < N*M; i++){
            int el = arr[i];
            int[] loc = location[el];

            aux[loc[0]][M] -= el;
            aux[N][loc[1]] -= el;

            if(aux[loc[0]][M] == 0 || aux[N][loc[1]] == 0){
                return i;
            }
        }

        return -1;
    }
}