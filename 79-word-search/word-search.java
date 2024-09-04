class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean res = find(board, i, j, 0, word);
                    if(res){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean find(char[][] board, int i, int j, int idx, String word){

        if(idx == word.length()){
            return true;
        }

        if(i == board.length || j == board[0].length || i < 0 || j < 0){
            return false;
        }

        boolean res = false;
        if(board[i][j] == word.charAt(idx)){
            board[i][j] = '#';
            // if(i + 1 < board.length){
                res = (res || find(board, i + 1, j, idx + 1, word));
            // }
            // if(j + 1 < board[0].length){
                res = (res || find(board, i, j + 1, idx + 1, word));
            // }
            // if(i - 1 >= 0){
                res = (res || find(board, i - 1, j, idx + 1, word));
            // }
            // if(j - 1 >= 0){
                res = (res || find(board, i, j - 1, idx + 1, word));
            // }
            board[i][j] = word.charAt(idx);
        }
        return res;
    }
}