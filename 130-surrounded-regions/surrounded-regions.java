class Solution {

    int m = -1;
    int n = -1;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(i*j == 0 || i == m - 1 || j == n - 1){
                    dfs(i, j, board);
                }
            }
        }

        for(char[] row: board){
            for(int i = 0; i < row.length; i++){
                if(row[i] == '#'){
                    row[i] = 'O';
                }else if(row[i] == 'O'){
                    row[i] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board){

        if(i < 0 || j < 0 || i >= m  || j >= n){
            return;
        }

        if(board[i][j] != 'O'){
            return;
        }

        board[i][j] = '#';

        dfs(i - 1, j, board);
        dfs(i, j - 1, board);
        dfs(i + 1, j, board);
        dfs(i, j + 1, board);

    }
}