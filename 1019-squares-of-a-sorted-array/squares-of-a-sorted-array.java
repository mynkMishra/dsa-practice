class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] ans = new int[N];

        int i = 0;
        int j = 0;

        while(j < N && A[j] < 0){
            j++;
        }

        i = j - 1;

        int k = 0;
        while(i >= 0 && j < N){
            int a = Math.abs(A[i]);
            int b = Math.abs(A[j]);

            if(a < b){
                ans[k] = a*a;
                i--;
            }else{
                ans[k] = b*b;
                j++;
            }
            k++;
        }

        while(i >= 0){
            ans[k] = A[i] * A[i];
            i--;
            k++;
        }

        while(j < N){
            ans[k] = A[j] * A[j];
            j++;
            k++;
        }

        return ans;
    }
}