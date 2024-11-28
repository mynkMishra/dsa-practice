class Solution {
    public int[][] minScore(int[][] grid) {
        
        int N = grid.length;
        int M = grid[0].length;
        
        List<int[]> nums = new ArrayList<>();

        int[] rowMax = new int[N];
        int[] colMax = new int[M];
        Arrays.fill(rowMax, 1);
        Arrays.fill(colMax, 1);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                nums.add(new int[]{grid[i][j], i, j});
            }
        }

        nums.sort((int[] a, int[] b) -> a[0] - b[0]);

        for(int[] num: nums){
            int val = num[0];
            int x = num[1];
            int y = num[2];

            int newVal = Math.max(rowMax[x], colMax[y]);
            grid[x][y] = newVal;

            rowMax[x] = newVal + 1;
            colMax[y] = newVal + 1;
        }

        return grid;
    }
}