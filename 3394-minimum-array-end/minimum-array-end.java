class Solution {
    public long minEnd(int n, int x) {
        
        n--;
        long temp = (long)x;
        long idxA = 0;
        long idxB = 0;
        while((temp & (1L << idxB)) > 0){
            idxB++;
        }
        
        while((n >> idxA) > 0){
            if((n & (1L << idxA)) > 0){
                temp = (long)(temp | (1L << idxB));
            }
            idxB++;
            idxA++;

            while((temp & (1L << idxB)) > 0){
                idxB++;
            }
        }

        return temp;
    }
}