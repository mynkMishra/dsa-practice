class Solution {
    List<Integer> xpos;
    List<Integer> ypos;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minArea(char[][] image, int x, int y) {
        int N = image.length;
        int M = image[0].length;

        xpos = new ArrayList<>();
        ypos = new ArrayList<>();

        solve(x, y, new boolean[N][M], image);

        Collections.sort(xpos);
        Collections.sort(ypos);

        int minX = xpos.get(0);
        int maxX = xpos.get(xpos.size() - 1);

        int minY = ypos.get(0);
        int maxY = ypos.get(ypos.size() - 1);

        int l = Math.abs(minX - maxX) + 1;
        int b = Math.abs(minY - maxY) + 1;

        return l*b;
    }

    public void solve(int r, int c, boolean[][] visited, char[][] image){

        visited[r][c] = true;
        xpos.add(r);
        ypos.add(c);

        for(int[] d: dir){
            int nx = r + d[0];
            int ny = c + d[1];
            if(isValid(nx, ny, visited, image)){
                solve(nx, ny, visited, image);
            }
        }
    }

    public boolean isValid(int r, int c, boolean[][] visited, char[][] image){
        return r >= 0 && c >= 0 && 
            r < image.length && c < image[0].length && 
            image[r][c] == '1' && !visited[r][c];
    }
}