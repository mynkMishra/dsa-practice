class Solution {

    int[][] gridH;
    int[][] gridV;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        gridH = new int[m][n];
        gridV = new int[m][n];

        for(int[] w: walls){
            int r = w[0];
            int c = w[1];

            gridH[r][c] = 2;
            gridV[r][c] = 2;
        }

        for(int[] g: guards){
            int r = g[0];
            int c = g[1];

            gridH[r][c] = -1;
            gridV[r][c] = -1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(gridV[i][j] != 2 && gridV[i - 1][j] == -1){
                    gridV[i][j] = -1;
                }
            }
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(gridV[i][j] != 2 && gridV[i + 1][j] == -1){
                    gridV[i][j] = -1;
                }
            }
        }

        for(int j = 1; j < n; j++){
            for(int i = 0; i < m; i++){
                if(gridH[i][j] != 2 && gridH[i][j - 1] == -1){
                    gridH[i][j] = -1;
                }
            }
        }

        for(int j = n - 2; j >= 0; j--){
            for(int i = 0; i < m; i++){
                if(gridH[i][j] != 2 && gridH[i][j + 1] == -1){
                    gridH[i][j] = -1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // System.out.print(grid[i][j] + " ");
                if(gridV[i][j] == 0 && gridH[i][j] == 0){
                    count++;
                }
            }
            // System.out.println();
        }

        return count;
    }

    // public void solve(int r, int c, int dirr, int dirc){

    //     if(r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 2){
    //         return;
    //     }

    //     grid[r][c] = 1;
    //     solve(r + dirr, c + dirc, dirr, dirc);
    // }
}