class Solution {
    public int[][] tourOfKnight(int m, int n, int r, int c) {
        int[][] ans = new int[m][n];

        ans[r][c] = -1;
        solve(r, c, 1, m, n, ans);
        ans[r][c] = 0;

        return ans;
    }

    public boolean isValid(int fromRow, int fromCol, int toRow, int toCol, int r, int c, int[][] ans){
        if(toRow >= r || toCol>=c || toRow < 0|| toCol < 0 || ans[toRow][toCol] != 0 || 
            !(Math.min(Math.abs(fromRow - toRow), Math.abs(fromCol - toCol)) == 1 &&
            Math.max(Math.abs(fromRow - toRow), Math.abs(fromCol - toCol)) == 2)
        ){
            return false;
        }

        return true;
    }

    public boolean solve(int m, int n, int count, int r, int c, int[][] ans){
        if(count == r*c){
            return true;
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(!isValid(m,n, i,j,r,c,ans)){
                    continue;
                }
                
                ans[i][j] = count;
                if(solve(i,j,count + 1, r, c, ans)){
                    return true;
                }
                ans[i][j] = 0;
            }
        }

        return false;
    }
}