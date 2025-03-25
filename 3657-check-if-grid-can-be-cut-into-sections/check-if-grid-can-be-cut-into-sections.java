class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] ycord = new int[rectangles.length][2];
        int[][] xcord = new int[rectangles.length][2];

        for(int i = 0; i < rectangles.length; i++){
            ycord[i][0] = rectangles[i][1];
            ycord[i][1] = rectangles[i][3];

            xcord[i][0] = rectangles[i][0];
            xcord[i][1] = rectangles[i][2];
        }

        Arrays.sort(ycord,(a, b) -> a[0] - b[0]);

        int count = 0;
        int st = ycord[0][0];
        int end = ycord[0][1];

        for(int i = 1; i < ycord.length; i++){
            if(end <= ycord[i][0]){
                count++;
                st = ycord[i][0];
                end = ycord[i][1];
            }else{
                end = Math.max(end, ycord[i][1]);
            }
        }

        if(count > 1){
            return true;
        }

        Arrays.sort(xcord,(a, b) -> a[0] - b[0]);

        count = 0;
        st = xcord[0][0];
        end = xcord[0][1];

        for(int i = 1; i < xcord.length; i++){
            if(end <= xcord[i][0]){
                count++;
                st = xcord[i][0];
                end = xcord[i][1];
            }else{
                end = Math.max(end, xcord[i][1]);
            }
        }

        if(count > 1){
            return true;
        }

        return false;
    }
}