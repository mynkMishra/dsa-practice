class Solution {
    public String longestPrefix(String s) {
        
        int len = 0;
        int[] lps = new int[s.length()];
        lps[0] = 0;

        int i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // int max = Integer.MIN_VALUE;
        // for(int el: lps){
        //     System.out.println(el);
        //     max = Math.max(max, el);
        // }

        return s.substring(0, lps[s.length() - 1]);
    }
}