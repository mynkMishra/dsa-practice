class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        String mid = "";

        for(char ch: s.toCharArray()){
            if(ch != '-'){
                boolean isDigit = ch - '0' >= 0 && ch - '0' <= 9;
                if(!isDigit){
                    mid += Character.toUpperCase(ch);
                }else{
                    mid += ch;
                }
            }
        }

        int count = 0;
        StringBuilder ans = new StringBuilder();

        for(int i = mid.length() - 1; i>=0; i--){
            ans.append(mid.charAt(i));
            count++;
            if(count == k && i != 0){
                ans.append('-');
                count = 0;
            }
        }

        return ans.reverse().toString();
    }
}