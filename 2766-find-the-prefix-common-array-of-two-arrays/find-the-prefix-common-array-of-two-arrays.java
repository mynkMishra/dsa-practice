class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int N = A.length;
        int[] C = new int[N];

        if(A[0] == B[0]){
            C[0]++;
        }
        
        A[Math.abs(A[0]) - 1] = A[Math.abs(A[0]) - 1]*(-1);
        B[Math.abs(B[0]) - 1] = B[Math.abs(B[0]) - 1]*(-1); 

        for(int i = 1; i < N; i++){
            C[i] = C[i - 1];

            if(Math.abs(A[i]) == Math.abs(B[i])){
                A[Math.abs(A[i]) - 1] = A[Math.abs(A[i]) - 1]*(-1);
                B[Math.abs(B[i]) - 1] = B[Math.abs(B[i]) - 1]*(-1); 
                C[i]++;
            }else{
                if(B[Math.abs(A[i]) - 1] < 0){
                    C[i]++;
                }
                if(A[Math.abs(B[i]) - 1] < 0){
                    C[i]++;
                }

                A[Math.abs(A[i]) - 1] = A[Math.abs(A[i]) - 1]*(-1);
                B[Math.abs(B[i]) - 1] = B[Math.abs(B[i]) - 1]*(-1); 
            }
        }

        return C;
    }
}