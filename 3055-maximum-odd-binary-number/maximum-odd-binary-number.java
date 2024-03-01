class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuffer sb = new StringBuffer(s);
        int count = 0;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '1'){
                count++;
                sb.setCharAt(i, '0');
            }
        }

        for(int i = 0; i < sb.length() - 1 && count > 1; i++){
            sb.setCharAt(i, '1');
            count--;
        }

        sb.setCharAt(sb.length() - 1, '1');
        return sb.toString();
    }
}