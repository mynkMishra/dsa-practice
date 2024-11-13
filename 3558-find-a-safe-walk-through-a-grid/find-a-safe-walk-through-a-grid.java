class Solution {

    class Cell{
        int r;
        int c;
        int h;

        Cell(int r, int c, int h){
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    int N;
    int M;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        N = grid.size();
        M = grid.get(0).size();

        boolean[][] visited = new boolean[N][M];

        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((a, b) -> a.h - b.h);
        pq.add(new Cell(0, 0, grid.get(0).get(0)));

        while(pq.size() != 0){

            Cell cell = pq.poll();

            if(health - cell.h <= 0 || visited[cell.r][cell.c]){
                continue;
            }

            if(cell.r == N - 1 && cell.c == M - 1){
                return true;
            }

            visited[cell.r][cell.c] = true;
            if(cell.r - 1 >= 0 && !visited[cell.r - 1][cell.c]){
                pq.add(new Cell(cell.r - 1, cell.c, cell.h + grid.get(cell.r - 1).get(cell.c)));
            }

            if(cell.c - 1 >= 0 && !visited[cell.r][cell.c - 1]){
                pq.add(new Cell(cell.r, cell.c - 1, cell.h + grid.get(cell.r).get(cell.c - 1)));
            }

            if(cell.r + 1 < N && !visited[cell.r + 1][cell.c]){
                pq.add(new Cell(cell.r + 1, cell.c, cell.h + grid.get(cell.r + 1).get(cell.c)));
            }

            if(cell.c + 1 < M && !visited[cell.r][cell.c + 1]){
                pq.add(new Cell(cell.r, cell.c + 1, cell.h + grid.get(cell.r).get(cell.c + 1)));
            }
        }

        return false;
    }
}