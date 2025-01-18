class Solution {

    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<List<String>>();

        String[][] matrix = new String[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = ".";
            }
        }
        for(int j = 0; j < n; j++){
            matrix[0][j] = "Q";
            solve(1, n - 1, matrix);
            matrix[0][j] = ".";
        }

        return ans;
    }

    public void solve(int r, int n, String matrix[][]){
        if(n == 0){
            List<String> list = new ArrayList<String>();

            for(String[] row: matrix){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < matrix.length; j++){
                    sb.append(row[j]);
                }
                list.add(sb.toString());
            }

            ans.add(list);
            return; 
        }

        for(int j = 0; j < matrix.length; j++){
            if(isValid(r, j, matrix)){
                matrix[r][j] = "Q";
                solve(r + 1, n - 1, matrix);
                matrix[r][j] = ".";
            }
        }
    }

    public boolean isValid(int r, int c, String[][] matrix){

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][c].equals("Q")){
                return false;
            }
        }

        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[r][j].equals("Q")){
                return false;
            }
        }

        int i = r;
        int j = c;
        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j].equals("Q")){
                return false;
            }

            i--;
            j++;
        }

        i = r;
        j = c;
        while(i >= 0 && j >= 0){
            if(matrix[i][j].equals("Q")){
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}