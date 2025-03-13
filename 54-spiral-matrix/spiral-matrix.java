class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int N = matrix.length;
        int M = matrix[0].length;

        int count = N*M;
        int r1 = 0;
        int c1 = 0;
        int r2 = N - 1;
        int c2 = M - 1;

        List<Integer> list = new ArrayList<Integer>();

        while(count > 0){

            for(int c = c1; c <= c2; c++){
                list.add(matrix[r1][c]);
                count--;
            }
            r1++;

            if(count == 0){
                break;
            }

            for(int r = r1; r <= r2; r++){
                list.add(matrix[r][c2]);
                count--;
            }
            c2--;

            if(count == 0){
                break;
            }

            for(int c = c2; c >= c1; c--){
                list.add(matrix[r2][c]);
                count--;
            }
            r2--;

            if(count == 0){
                break;
            }

            for(int r = r2; r >= r1; r--){
                list.add(matrix[r][c1]);
                count--;
            }
            c1++;
        }

        return list;
    }
}