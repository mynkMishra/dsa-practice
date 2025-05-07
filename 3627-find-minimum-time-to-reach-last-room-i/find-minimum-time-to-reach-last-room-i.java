class Solution {

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int N = moveTime.length;
        int M = moveTime[0].length;

        boolean[][] visited = new boolean[N][M];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while(queue.size() > 0){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int t = cell[2];

            if(r == N - 1 && c == M - 1){
                return t;
            }

            for(int[] d: dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    if(t >= moveTime[nr][nc]){
                        queue.add(new int[]{nr, nc, t + 1});
                    }else{
                        queue.add(new int[]{nr, nc, moveTime[nr][nc] + 1});
                    }
                }
            }
        }

        return 0;
    }
}