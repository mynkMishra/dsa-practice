class Solution {
    public int[] decrypt(int[] code, int k) {
        int N = code.length;
        int[] ans = new int[N];

        int l = 0;
        int prevSum = 0;
        for(int i = N - 1; i >= N - Math.abs(k); i--){
            prevSum += code[i];
            l = i;
        }

        int r = 0;
        int nextSum = 0;
        for(int i = 1; i <= k; i++){
            nextSum += code[i];
            r = i;
        }

        for(int i = 0; i < N; i++){
            if(k == 0){
                ans[i] = 0;
            }else if(k > 0){
                ans[i] = nextSum;

                if(i < N - 1){
                    nextSum = nextSum - code[i + 1];
                }
                
                if(r < N - 1){
                    r++;
                    nextSum += code[r];
                }else if(r == N - 1){
                    r = 0;
                    nextSum += code[r];
                }
            }else{
                // System.out.println(prevSum);
                ans[i] = prevSum;

                prevSum = prevSum + code[i];
                
                if(l < N){
                    prevSum -= code[l];
                    l++;
                    if(l == N){
                        l = 0;
                    }
                }
            }
        }

        return ans;
    }
}