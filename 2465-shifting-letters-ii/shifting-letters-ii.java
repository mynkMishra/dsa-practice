class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] prefix = new int[s.length()];

        for(int[] t: shifts){
            int l = t[0];
            int r = t[1];
            int d = t[2];

            if(d == 1){
                prefix[l]++;
                if(r + 1 < prefix.length){
                    prefix[r + 1]--;
                }
            }else{
                prefix[l]--;
                if(r + 1 < prefix.length){
                    prefix[r + 1]++;
                }
            }
        }

        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i -1] + prefix[i];
        }

        char[] chars = s.toCharArray();
        for(int i = 0; i < prefix.length; i++){
            int ascii = chars[i] - 'a';
          
            int newAscii = (ascii + prefix[i]);
            if(newAscii < 0){
                int d = ascii + prefix[i]%26;
                char nch = (char)('a' + (26 + d)%26);
                // System.out.println(d + " " + nch);
                chars[i] = nch;
            }else{
                char nch = (char)('a' + newAscii%26);
                chars[i] = nch;
            }
        }
        return String.valueOf(chars);
    }
}