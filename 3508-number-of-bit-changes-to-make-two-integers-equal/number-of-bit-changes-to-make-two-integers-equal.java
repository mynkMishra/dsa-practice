class Solution {
    public int minChanges(int n, int k) {
        int xor = (n ^ k);
        int res = 0;
        int i = 0;
        while(i < 31){
            if((xor & (1 << i)) > 0){
                if((n & (1 << i)) > 0){
                    res++;
                }else{
                    return -1;
                }
            }
            i++;
        }

        return res;
    }
}