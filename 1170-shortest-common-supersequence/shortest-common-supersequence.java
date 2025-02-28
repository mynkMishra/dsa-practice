class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int L1 = str1.length();
        int L2 = str2.length();

        int[][] dp = new int[L1 + 1][L2 + 1];

        for(int i = 0; i <= L1; i++){
            dp[i][0] = i;
        }

        for(int j = 0; j <= L2; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= L1; i++){
            for(int j = 1; j <= L2; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        int r = L1;
        int c = L2;
        StringBuilder superSeq = new StringBuilder();

        while(r > 0 && c > 0){
            if(str1.charAt(r - 1) == str2.charAt(c - 1)){
                superSeq.append(str1.charAt(r - 1));
                r--;
                c--;
            }else{
                if(dp[r - 1][c] < dp[r][c - 1]){
                    superSeq.append(str1.charAt(r - 1));
                    r--;
                }else{
                    superSeq.append(str2.charAt(c - 1));
                    c--;
                }
            }
        }

        while(r > 0){
            superSeq.append(str1.charAt(r - 1));
            r--;
        }

        while(c > 0){
            superSeq.append(str2.charAt(c - 1));
            c--;
        }

        return superSeq.reverse().toString();
    }
}