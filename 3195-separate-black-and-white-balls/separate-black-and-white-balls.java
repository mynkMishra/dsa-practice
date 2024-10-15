class Solution {
    public long minimumSteps(String s) {
        
        int N = s.length();
        long ans = 0;
        int zeroCount = 0;

        for(int i = N - 1; i >= 0 ; i--){
            if(s.charAt(i) == '0'){
                zeroCount++;
            }else{
                ans += (long)zeroCount;
            }
        }

        return ans;
    }
}