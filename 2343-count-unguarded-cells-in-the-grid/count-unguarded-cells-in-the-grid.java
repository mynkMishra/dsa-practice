class Solution {

    int[][] gridH;
    int[][] gridV;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        gridH = new int[m][n];
        gridV = new int[m][n];

        for(int[] g: guards){
            int i = g[0];
            int j = g[1];

            gridH[i][j] = -1;
            gridV[i][j] = -1;
        }

        for(int[] w: walls){
            int i = w[0];
            int j = w[1];

            gridH[i][j] = 2;
            gridV[i][j] = 2;
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(gridH[i][j] != 2 && gridH[i - 1][j] == -1){
                    gridH[i][j] = -1;
                }
            }
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(gridH[i][j] != 2 && gridH[i + 1][j] == -1){
                    gridH[i][j] = -1;
                }
            }
        }

        for(int j = 1; j < n; j++){
            for(int i = 0; i < m; i++){
                if(gridV[i][j] != 2 && gridV[i][j - 1] == -1){
                    gridV[i][j] = -1;
                }
            }
        }

        for(int j = n - 2; j >= 0; j--){
            for(int i = 0; i < m; i++){
                if(gridV[i][j] != 2 && gridV[i][j + 1] == -1){
                    gridV[i][j] = -1;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(gridH[i][j] == 0 && gridV[i][j] == 0){
                    ans++;
                }
            }
        }

        return ans;
    }
}