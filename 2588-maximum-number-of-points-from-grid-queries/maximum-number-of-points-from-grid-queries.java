class Solution {

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;

        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = queries[i];
        }

        Arrays.sort(queries);
        
        Map<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<int[]> minH = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minH.add(new int[]{0, 0, grid[0][0]});
        grid[0][0] = 0;

        int totalPoints = 0;

        for(int i = 0; i < k; i++){
            int q = queries[i];

            while(minH.size() > 0 && minH.peek()[2] < q){

                int[] el = minH.poll();
                int r = el[0];
                int c = el[1];
                
                totalPoints++;

                for(int[] d: dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(isValid(nr, nc, grid) && grid[nr][nc] != 0){
                        minH.add(new int[]{nr, nc, grid[nr][nc]});
                        grid[nr][nc] = 0;
                    }
                }
            }

            hm.put(q, totalPoints);
        }

        int[] ans = new int[k];

        for(int i = 0; i < k; i++){
            int q = arr[i];
            ans[i] = hm.get(q);
        }
        
        return ans;
    }

    public boolean isValid(int r, int c, int[][] grid){
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }
}