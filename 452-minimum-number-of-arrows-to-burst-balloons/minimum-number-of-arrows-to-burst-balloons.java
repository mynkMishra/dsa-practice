class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);
        int[] curr = points[0];
        int count = 1;
        for(int i = 1; i < points.length; i++){
            // System.out.println(curr[0] + " " + curr[1]);
            if(curr[0] <= points[i][0] && points[i][0] <= curr[1]){
                curr[0] = Math.max(curr[0], points[i][0]);
                curr[1] = Math.min(curr[1], points[i][1]);
            }else{
                // System.out.println(points[i][0] + " " + points[i][1]);
                curr = points[i];
                count++;
            }
        }
        return count;
    }
}