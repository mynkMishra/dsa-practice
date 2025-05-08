class Solution {

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minTimeToReach(int[][] moveTime) {
        
        int N = moveTime.length;
        int M = moveTime[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0, 0, 0, 1});

        boolean[][] visited = new boolean[N][M];
        
        while(queue.size() > 0){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int t = cell[2];
            int time = cell[3];

            if(r == N - 1 && c == M - 1){
                return t;
            }

            if(visited[r][c]){
                continue;
            }

            visited[r][c] = true;

            for(int[] d: dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >= 0 && nc >= 0 && nr < N && nc < M){
                    if(time == 1){
                        queue.add(new int[]{nr, nc, Math.max(t, moveTime[nr][nc]) + time, 2});
                    }else{
                        queue.add(new int[]{nr, nc, Math.max(t, moveTime[nr][nc]) + time, 1});
                    }
                }
            }
        }

        return 0;
    }
}