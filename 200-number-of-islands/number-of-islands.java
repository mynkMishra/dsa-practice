class Solution {

    int N = -1;
    int M = -1;
    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        
        N = grid.length;
        M = grid[0].length;

        boolean[][] visited = new boolean[N][M];
        int ans = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    ans++;
                    dfs(i, j, visited, grid);
                }
            }
        }

        return ans;
    }

    public void dfs(int i, int j, boolean[][] visited, char[][] grid){

        for(int[] d: dir){
            int ni = i + d[0];
            int nj = j + d[1];

            if(isValid(ni, nj) && !visited[ni][nj] && grid[ni][nj] == '1'){
                visited[ni][nj] = true;
                dfs(ni, nj, visited, grid);
            }
        }
    }

    public boolean isValid(int i, int j){
        return  i >= 0 && j >= 0 && i < N && j < M;
    }
}