class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        
        boolean[] numAdded = new boolean[10];
        return solve(0, numAdded, n) + 1;
    }

    public int solve(int idx, boolean[] numAdded, int n){

        if(idx == n){
            return 0;
        }

        int count = 0;
        for(int i = idx == 0 ? 1 : 0; i <= 9; i++){
            if(!numAdded[i]){
                numAdded[i] = true;
                count += solve(idx + 1, numAdded, n) + 1;
                numAdded[i] = false;
            }
        }

        return count;
    }
}