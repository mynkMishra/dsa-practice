class Solution {

    List<List<String>> board;
    List<List<String>> ans;
    boolean[][] visited;
    int N;
    public List<List<String>> solveNQueens(int n) {
        N = n;
        visited = new boolean[n][n];
        board = new ArrayList<List<String>>();
        ans = new ArrayList<List<String>>();

        for(int i = 1; i <= n; i++){
            List<String> list = new ArrayList<String>();
            for(int j = 1; j <= n; j++){
                list.add(".");
            }
            board.add(list);
        }

        solve(n, 0); 

        return ans;
    }

    public boolean isValidRow(int r){
        for(String str: board.get(r)){
            if(str.equals("Q")){
                return false;
            }
        }

        return true;
    }

    public boolean isValidCol(int c){
        for(int i = 0; i < board.size(); i++){
            if(board.get(i).get(c).equals("Q")){
                return false;
            }
        }

        return true;
    }

    public boolean isValidDiagonal(int r, int c){

        int n = board.size();
        int i = r - 1;
        int j = c - 1;

        while(i >= 0 && j >= 0){
            if(board.get(i).get(j).equals("Q")){
                return false;
            }
            i--;
            j--;
        }

        i = r - 1;
        j = c + 1;

        while(i >= 0 && j < n){
            if(board.get(i).get(j).equals("Q")){
                return false;
            }
            i--;
            j++;
        }

        i = r + 1;
        j = c + 1;

        while(i < n && j < n){
            if(board.get(i).get(j).equals("Q")){
                return false;
            }
            i++;
            j++;
        }

        i = r + 1;
        j = c - 1;

        while(i < n && j >= 0){
            if(board.get(i).get(j).equals("Q")){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public void solve(int n, int r){

        if(n == 0){
            List<String> list = new ArrayList<String>();
            for(int i = 0; i < N; i++){
                String str = "";
                for(int j = 0; j < N; j++){
                    str += board.get(i).get(j);
                }
                list.add(str);
            }
            ans.add(list);
            return;
        }

        if(r >= N){
            return;
        }

        
        for(int c = 0; c < N; c++){
            if(board.get(r).get(c).equals(".") && isValidCol(c) && isValidRow(r) && isValidDiagonal(r,c)){
                board.get(r).set(c, "Q");
                solve(n - 1, r + 1) ;
                board.get(r).set(c, ".");
            }
        }
        
    }
}