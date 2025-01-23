class Solution {

    int N, M;
    public int countServers(int[][] grid) {
        N = grid.length;
        M = grid[0].length;

        boolean[][] visited = new boolean[N][M];
        int ans = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int t = bfs(i, j, visited, grid);
                    if(t == 1){
                        boolean can = false;
                        for(int k = 0; k < N; k++){
                            if(grid[k][j] == 1 && k != i){
                                can = true;
                                break;
                            }
                        }

                        if(!can){
                            for(int k = 0; k < M; k++){
                                if(grid[i][k] == 1 && k != j){
                                    can = true;
                                    break;
                                }
                            }
                        }
                        
                        if(can){
                            ans += 1;
                        }
                    }else{
                        ans += t;
                    }
                }
            }   
        }

        return ans;
    }

    public int bfs(int i, int j, boolean[][] visited, int[][] grid){

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        LinkedList<int[]> queue = new LinkedList<int[]>();
        visited[i][j] = true;
        queue.add(new int[]{i, j});

        int count = 0;
        while(queue.size() > 0){
            int[] el = queue.poll();
            int r = el[0];
            int c = el[1];

            count++;

            for(int[] d: dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(isValid(nr, nc) && grid[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr,nc});
                }
            }
        }

        return count;
    }

    public boolean isValid(int i, int j){
        return i >= 0 && j >= 0 && i < N && j < M;
    }
}