class Solution {
    public boolean exist(char[][] board, String word) {

        int N = board.length;
        int M = board[0].length;

        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == word.charAt(0) && solve(i, j, 0, visited, board, word)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean solve(int i, int j, int idx, boolean[][] visited, char[][] board, String word){

        if(idx == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }

        if(visited[i][j] || board[i][j] != word.charAt(idx)){
            return false;
        }

        visited[i][j] = true;
        boolean res = solve(i + 1, j, idx + 1, visited, board, word) ||
        solve(i - 1, j, idx + 1, visited, board, word) || 
        solve(i, j + 1, idx + 1, visited, board, word) ||
        solve(i, j - 1, idx + 1, visited, board, word);

        if(!res){
            visited[i][j] = false;
        }

        return res;
    }
}