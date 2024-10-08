class Solution {
    public int minSwaps(String s) {

        StringBuilder sb = new StringBuilder(s);

        int N = s.length();
        int l = 0;
        int r = N - 1;
        int count = 0;

        int op = 0;
        int cl = 0;
        while(l < N){
            if(sb.charAt(l) == '['){
                op++;
            }
            if(sb.charAt(l) == ']'){
                cl++;
            }

            if(cl > op){
                while(r >= 0 && s.charAt(r) == ']'){
                    r--;
                }

                count++;
                sb.setCharAt(r, ']');
                sb.setCharAt(l, '[');

                cl--;
                op++;
            }

            l++;
        }

        return count;
    }
}