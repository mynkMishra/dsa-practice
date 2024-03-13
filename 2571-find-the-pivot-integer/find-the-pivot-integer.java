class Solution {
    public int pivotInteger(int n) {
        int total = n*(n + 1)/2;

        for(int i = 1; i <= n; i++){
            int sum1 = i*(i + 1)/2;
            int sum2 = total - sum1 + i;

            if(sum1 == sum2){
                return i;
            }
        }

        return -1;
    }
}