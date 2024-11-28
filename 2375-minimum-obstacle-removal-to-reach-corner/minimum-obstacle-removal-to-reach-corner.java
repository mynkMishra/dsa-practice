class Solution {

    class Cell{
        int x;
        int y;
        int obs;

        Cell(int x, int y, int obs){
            this.x = x;
            this.y = y;
            this.obs = obs;
        }
    }

    public int minimumObstacles(int[][] grid) {

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n]; 

        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((Cell a, Cell b) -> a.obs - b.obs);
        pq.add(new Cell(0,0,0));

        while(pq.size() > 0){
            Cell cell = pq.poll();

            if(cell.x == m - 1 && cell.y == n - 1){
                return cell.obs;
            }

            for(int i = 0; i <= 3; i++){
                int ni = cell.x + dir[i][0];
                int nj = cell.y + dir[i][1];
                if(ni >= 0 && nj >= 0 && ni < m && nj < n && !visited[ni][nj]){
                    int obs = grid[ni][nj] + cell.obs;
                    visited[ni][nj] = true;
                    pq.add(new Cell(ni, nj, obs));
                }
            }
        }

        return -1;

    }
}