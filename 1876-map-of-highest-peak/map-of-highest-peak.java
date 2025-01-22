class Solution {

    public int[][] highestPeak(int[][] isWater) {

        int N = isWater.length;
        int M = isWater[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] height = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<int[]> minH = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                height[i][j] = isWater[i][j] == 1 ? 0 : 1;
                if(isWater[i][j] == 1){
                    minH.add(new int[]{i,j,0});
                }
            }
        }

        while(minH.size() > 0){
            int[] el = minH.poll();
            int i = el[0];
            int j = el[1];
            int h = el[2];

            if(visited[i][j]){
                continue;
            }

            visited[i][j] = true;
            height[i][j] = h;

            for(int[] d: dir){
                int ni = i + d[0];
                int nj = j + d[1];

                if(isValid(ni, nj, N, M) && height[ni][nj] != 0 && !visited[ni][nj]){
                    minH.add(new int[]{ni, nj, h + 1});
                }
            }
        }

        return height;


    }

    public boolean isValid(int i, int j, int N, int M){
        return i >= 0 && j >= 0 && i < N && j < M;
    }
}