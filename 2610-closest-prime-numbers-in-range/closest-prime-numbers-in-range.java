class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] aux = new int[right + 1];

        for(int i = 1; i <= right; i++){
            if(right/i >= i){
                for(int j = i*i; j <= right; j+=i){
                    aux[j]++;
                }
            }
            
        }

        aux[1] = 0;

        int[] ans = new int[]{-1, -1};
        int a = -1;
        int b = -1;
        int diff = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++){
            if(aux[i] == 1){
                if(a == -1){
                    a = i;
                }else if(b == -1){
                    b = i;
                    ans[0] = a;
                    ans[1] = b;
                    diff = b - a;
                }else{
                    a = b;
                    b = i;

                    if(b - a < diff){
                        ans[0] = a;
                        ans[1] = b;
                        diff = b - a;
                    }
                }
            }
        }

        return ans;
    }
}