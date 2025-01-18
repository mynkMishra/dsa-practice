class Solution {
    public int minCost(int[][] grid) {
        
        int N = grid.length;
        int M = grid[0].length;

        boolean[][] visited = new boolean[N][M];

        PriorityQueue<int[]> minH = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        minH.add(new int[]{0, 0, 0});

        int ans = Integer.MAX_VALUE;

        while(minH.size() > 0){
            int[] cell = minH.poll();
            int x = cell[0];
            int y = cell[1];
            int cost = cell[2];

            if(x >= N || y >= M || x < 0 || y < 0 || visited[x][y]){
                continue;
            }

            if(x == N - 1 && y == M - 1){
                ans = Math.min(ans, cost);
                continue;
            }

            visited[x][y] = true;

            if(grid[x][y] == 1){
                minH.add(new int[]{x - 1, y, cost + 1});
                minH.add(new int[]{x, y - 1, cost + 1});
                minH.add(new int[]{x, y + 1, cost});
                minH.add(new int[]{x + 1, y, cost + 1});
            }else if(grid[x][y] == 2){
                minH.add(new int[]{x - 1, y, cost + 1});
                minH.add(new int[]{x, y - 1, cost});
                minH.add(new int[]{x, y + 1, cost + 1});
                minH.add(new int[]{x + 1, y, cost + 1});
            }else if(grid[x][y] == 3){
                minH.add(new int[]{x - 1, y, cost + 1});
                minH.add(new int[]{x, y - 1, cost + 1});
                minH.add(new int[]{x, y + 1, cost + 1});
                minH.add(new int[]{x + 1, y, cost});
            }else if(grid[x][y] == 4){
                minH.add(new int[]{x - 1, y, cost});
                minH.add(new int[]{x, y - 1, cost + 1});
                minH.add(new int[]{x, y + 1, cost + 1});
                minH.add(new int[]{x + 1, y, cost + 1});
            }
        }

        return ans;
    }
}