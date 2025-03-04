class Solution {
    public boolean checkPowersOfThree(int n) {
        
        int p = 0;
        while(Math.pow(3, p) <= n){
            p++;
        }
        p--;

        while(n > 0){

            if(p < 0){
                return false;
            }
            
            if(Math.pow(3, p) <= n){
                n -= (int)Math.pow(3, p);
            }
            p--;
        }

        return true;
    }
}