class Solution {

    long mod = 1_000_000_000 + 7;
    public int countGoodNumbers(long n) {
        
        long pLen = n/2;
        long eLen = n - pLen;

        long pExp = power(4, pLen)%mod;
        long eExp = power(5, eLen)%mod;

        return (int)((pExp*eExp)%mod);
    }

    public long power(long base, long n){
        if(n == 1){
            return base;
        }

        if(n == 0){
            return 1L;
        }

        long v = power(base, n/2)%mod;
        if(n%2 == 0){
            return (v*v)%mod;
        }else{
            return (((v*v)%mod)*base)%mod;
        }
    }
}