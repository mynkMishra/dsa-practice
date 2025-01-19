class Solution {

    class Cell{
        int row;
        int col;
        int height;

        Cell(int r, int c, int h){
            row = r;
            col = c;
            height = h;
        }
    }

    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int trapRainWater(int[][] heightMap) {

        int N = heightMap.length;
        int M = heightMap[0].length;

        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Cell> minH = new PriorityQueue<Cell>((a, b) -> a.height - b.height);

        for(int i = 0; i < N; i++){
            visited[i][0] = true;
            minH.add(new Cell(i, 0, heightMap[i][0]));

            visited[i][M - 1] = true;
            minH.add(new Cell(i, M - 1, heightMap[i][M - 1]));
        }  

        for(int j = 0; j < M; j++){
            visited[0][j] = true;
            minH.add(new Cell(0, j, heightMap[0][j]));

            visited[N - 1][j] = true;
            minH.add(new Cell(N - 1, j, heightMap[N - 1][j]));
        }   

        int totalVol = 0;

        while(minH.size() > 0){
            Cell cell = minH.poll();

            int row = cell.row;
            int col = cell.col;
            int minBoundaryHeight = cell.height;

            for(int i = 0; i <= 3; i++){
                int nrow = row + dir[i][0];
                int ncol = col + dir[i][1];

                if(nrow < N && ncol < M && nrow >= 0 && ncol >= 0 && !visited[nrow][ncol]){
                    int nHeight = heightMap[nrow][ncol];

                    if(minBoundaryHeight > nHeight){
                        totalVol += (minBoundaryHeight - nHeight);
                    }

                    minH.add(new Cell(nrow, ncol, Math.max(nHeight, minBoundaryHeight)));
                    visited[nrow][ncol] = true;
                }
            }
        }
        return totalVol;
    }
}