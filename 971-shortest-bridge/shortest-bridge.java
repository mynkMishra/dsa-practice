class Solution {

    class Cell{
        int count;
        int x;
        int y;

        Cell(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int shortestBridge(int[][] grid) {
        
        int N = grid.length;
        int M = grid[0].length;
        int x = -1, y = -1, marker = 2;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 1){

                    if(x == -1 && y == -1){
                        x = i;
                        y = j;
                    }

                    dfs(i, j, marker, grid);
                    marker = 3;
                }
            }
        }

        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < M; j++){
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        boolean[][] visited = new boolean[N][M];

        PriorityQueue<Cell> queue = new PriorityQueue<Cell>((Cell a, Cell b) -> a.count - b.count);
        queue.add(new Cell(x, y, 0));

        while(queue.size() > 0){
            Cell c = queue.poll();

            if(visited[c.x][c.y]){
                continue;
            }

            if(grid[c.x][c.y] == 3){
                return c.count - 1;
            }

            visited[c.x][c.y] = true;

            for(int[] d: dir){
                int nx = c.x + d[0];
                int ny = c.y + d[1];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(grid[nx][ny] == 2){
                        queue.add(new Cell(nx, ny, c.count));
                    }else{
                        queue.add(new Cell(nx, ny, c.count + 1));
                    }
                }
                
            }
        }

        return 0;

    }

    public void dfs(int i, int j, int marker, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == marker || grid[i][j] == 0){
            return;
        }

        grid[i][j] = marker;

        for(int[] d: dir){
            dfs(i + d[0], j + d[1], marker, grid);
        }

    }
}