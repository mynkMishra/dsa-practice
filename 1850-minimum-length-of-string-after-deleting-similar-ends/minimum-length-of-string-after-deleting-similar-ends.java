class Solution {
    public int minimumLength(String s) {
        StringBuffer sb = new StringBuffer(s);

        boolean run = true;
        int start = 0;
        int end = sb.length() - 1;

        while(start < end){
            // System.out.println(start + " " + end);
            int ps = start;
            int pe = start;

            while(pe + 1 < s.length() && sb.charAt(ps) == sb.charAt(pe + 1)){
                pe++;
            }

            int ss = end;
            int se = end;

            while(ss - 1 >= 0 && sb.charAt(ss - 1) == sb.charAt(se)){
                ss--;
            }

            if(sb.charAt(pe) != sb.charAt(ss)){
                // System.out.println(pe + " " + ss);
                return end - start + 1;
            }

            start = pe + 1;
            end = ss - 1;
        }
        // System.out.println(start + " " + end);
        if(start == end){
            return 1;
        }
        return 0;
    }
}