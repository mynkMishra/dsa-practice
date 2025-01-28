class Solution {
    public int findMaxFish(int[][] grid) {
        
        int N = grid.length;
        int M = grid[0].length;
        boolean[][] visited = new boolean[N][M];
        int ans = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && grid[i][j] != 0){
                    ans = Math.max(ans, bfs(i, j, visited, grid));
                }
            }
        }

        return ans;
    }

    public int bfs(int x, int y, boolean[][] visited, int[][] grid){
        
        int count = 0;
        int N = grid.length;
        int M = grid[0].length;
        int[][] dir = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.addLast(new int[]{x, y, grid[x][y]});

        while(queue.size() > 0){
            int[] el = queue.removeFirst();
            int u = el[0];
            int v = el[1];
            int w = el[2];

            if(visited[u][v]){
                continue;
            }
            count += w;
            visited[u][v] = true;

            for(int[] d: dir){
                int nr = u + d[0];
                int nc = v + d[1];

                if(isValid(nr, nc, N, M) && !visited[nr][nc] && grid[nr][nc] != 0){
                    queue.addLast(new int[]{nr, nc, grid[nr][nc]});
                }
            }
        }

        return count;
    }

    public boolean isValid(int r, int c, int R, int C){
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}