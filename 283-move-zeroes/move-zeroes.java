class Solution {
    public void moveZeroes(int[] A) {

        int N  = A.length;
        int i = 0;

        while(i < N && A[i] != 0){
            i++;
        }

        int j = i + 1;
        while(j < N){
            if(A[j] == 0){
                j++;
            }else{
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j++;
            }
        }
    }
}