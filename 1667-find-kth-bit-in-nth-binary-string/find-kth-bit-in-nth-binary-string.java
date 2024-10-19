class Solution {
    public char findKthBit(int n, int k) {
        
        StringBuilder sb = new StringBuilder("0");

        for(int i = 2; i <= n; i++){
            StringBuilder rev = new StringBuilder();

            for(int j = sb.length() - 1; j >= 0; j--){
                rev.append(sb.charAt(j) == '0' ? "1" : "0");
            }

            sb.append("1" + rev.toString());
        }

        return sb.charAt(k - 1);
    }
}