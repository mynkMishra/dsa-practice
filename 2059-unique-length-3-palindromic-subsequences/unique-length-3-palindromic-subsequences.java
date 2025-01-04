class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int ascii = ch - 'a';
            if(first[ascii] == -1){
                first[ascii] = i;
            }
        }

        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            int ascii = ch - 'a';
            if(last[ascii] == -1){
                last[ascii] = i;
            }
        }

        int ans = 0;
        for(int i = 0; i < 26; i++){
            if(first[i] != -1 && last[i] != -1 && last[i] - first[i] >= 2){
                int l = first[i];
                int r = last[i];
                Set<Character> hs = new HashSet<Character>();

                for(int k = l + 1; k < r; k++){
                    char ch = s.charAt(k);
                    if(!hs.contains(ch)){
                        ans++;
                        hs.add(ch);
                    }
                }
            }
        }

        return ans;
    }
}