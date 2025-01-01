class Solution {
    public int maxScore(String s) {
        
        int totalZero = 0;
        int totalOnes = 0;

        int zero = 0;
        int ones = 0;

        for(char ch: s.toCharArray()){
            if(ch == '0'){
                totalZero++;
            }
            if(ch == '1'){
                totalOnes++;
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < s.length() - 1; i++){
            char ch = s.charAt(i);
            if(ch == '0'){
                zero++;
            }
            if(ch == '1'){
                ones++;
            }

            ans = Math.max(zero + totalOnes - ones, ans);
        }

        return ans;
    }
}