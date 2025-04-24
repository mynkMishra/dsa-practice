class Solution {

    class Cell{
        int x;
        int y;
        int val;

        Cell(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int N, M;
    int ans;
    PriorityQueue<Cell> minH;

    public int orangesRotting(int[][] grid) {
        
        N = grid.length;
        M = grid[0].length;

        boolean[][] visited = new boolean[N][M];
        minH = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = true;
                    minH.add(new Cell(i, j, 0));
                }
            }
        }

        bfs(visited, grid);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans;
    }

    public void bfs(boolean[][] visited, int[][] grid){

        while(minH.size() > 0){
            Cell c = minH.poll();

            ans = Math.max(ans, c.val);

            for(int[] d: dir){
                int nx = c.x + d[0];
                int ny = c.y + d[1];
                if(isValid(nx, ny, N, M, visited, grid)){
                    visited[nx][ny] = true;
                    grid[nx][ny] = 2;
                    minH.add(new Cell(nx, ny, c.val + 1));
                }
            }
        }
    }

    public boolean isValid(int x, int y, int N, int M, boolean[][] visited, int[][] grid){
        return x >= 0 && y >= 0 && x < N && y < M && !visited[x][y] && grid[x][y] == 1;
    }
}