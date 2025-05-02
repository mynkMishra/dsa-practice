class Solution {

    int POWER = 100_000_1;
    public String pushDominoes(String dominoes) {
        
        int N = dominoes.length();

        int[] right = new int[N];

        int i = 0;
        while(i < N){
            char ch = dominoes.charAt(i);
            if(ch == 'R'){
                int st = POWER;
                right[i] = st;
                st--;
                i++;
                while(i < N && dominoes.charAt(i) == '.'){
                    right[i] = st;
                    st--;
                    i++;
                }
            }else{
                i++;
            }
        }

        int[] left = new int[N];

        i = N - 1;
        while(i >= 0){
            char ch = dominoes.charAt(i);
            if(ch == 'L'){
                int st = POWER;
                left[i] = st;
                st--;
                i--;
                while(i >=0 && dominoes.charAt(i) == '.'){
                    left[i] = st;
                    st--;
                    i--;
                }
            }else{
                i--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < N; i++){

            if(left[i] > right[i]){
                sb.append("L");
            }else if(left[i] < right[i]){
                sb.append("R");
            }else{
                sb.append(".");
            }
        }

        return sb.toString();
    }
}