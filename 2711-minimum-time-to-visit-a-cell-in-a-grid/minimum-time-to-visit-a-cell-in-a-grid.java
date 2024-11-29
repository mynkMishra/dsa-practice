class Solution {

    class Cell{
        int x;
        int y;
        int time;

        Cell(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.time = t;
        }
    }
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int N = grid.length;
        int M = grid[0].length;
        int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
        int[][] aux = new int[N][M];
        
        for(int[] row: aux){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((Cell a, Cell b) -> a.time - b.time);
        pq.add(new Cell(0,0,0));

        while(pq.size() > 0){

            Cell cell = pq.poll();
            
            if(cell.x == N - 1 && cell.y == M - 1){
                return cell.time;
            }

            if(visited[cell.x][cell.y]){
                continue;
            }

            visited[cell.x][cell.y] = true;
            for(int i = 0; i <= 3; i++){
                int nx = cell.x + dir[i][0];
                int ny = cell.y + dir[i][1];
                int time = cell.time;

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]){
                    int waitTime = (grid[nx][ny] - time)%2 == 0 ? 1 : 0;
                    int nextTime = Math.max(grid[nx][ny] + waitTime, time + 1);
                    pq.add(new Cell(nx, ny, nextTime));
                }
            }
        }

        return -1;
    }
}