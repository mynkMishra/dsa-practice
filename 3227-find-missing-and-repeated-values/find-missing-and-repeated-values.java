class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        int[] aux = new int[n*n + 1];
        int a = -1;
        int b = -1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                aux[grid[i][j]]++;
                if(aux[grid[i][j]] == 2){
                    a = grid[i][j];
                }
            }
        }

        for(int i = 1; i < aux.length; i++){
            if(aux[i] == 0){
                b = i;
                break;
            }
        }

        return new int[]{a, b};
    }
}