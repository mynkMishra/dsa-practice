class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int N = box.length;
        int M = box[0].length;

        for(int i = N - 1; i >= 0; i--){
            int C = M;
            for(int j = M - 1; j >= 0; j--){
                if(box[i][j] == '#'){
                    if(C - 1 != j){
                        box[i][C - 1] = '#';
                        box[i][j] = '.';
                    }
                    
                    C--;
                }else if(box[i][j] == '*'){
                    C = j;
                }
            }
        }

        char[][] ans = new char[M][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                ans[j][i] = box[i][j];
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N/2; j++){
                char temp = ans[i][N -j - 1];
                ans[i][N -j - 1] = ans[i][j];
                ans[i][j] = temp;
            }
        }

        return ans;
    }
}