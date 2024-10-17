class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(num + "");
        int len = sb.length();

        int start = 0;
        for(int i = 1; i < len; i++){
            int a = Integer.parseInt(sb.charAt(i - 1) + "");
            int b = Integer.parseInt(sb.charAt(i) + "");
            if(a >= b){
                start++;
            }else{
                break;
            }
        }

        int max = Integer.MIN_VALUE;
        int maxIdx = -1;

        for(int i = start; i < len; i++){
            int val = Integer.parseInt(sb.charAt(i) + "");

            if(val >= max){
                max = val;
                maxIdx = i;
            }            
        }

        int min = max;
        int minIdx = -1;
        for(int i = 0; i < len; i++){
            int val = Integer.parseInt(sb.charAt(i) + "");

            if(val < min){
                min = val;
                minIdx = i;
                break;
            }
        }

        if(minIdx == -1){
            return num;
        }

        sb.replace(maxIdx, maxIdx + 1, min + "");
        sb.replace(minIdx, minIdx + 1, max + "");

        return Integer.parseInt(sb.toString());
    }
}