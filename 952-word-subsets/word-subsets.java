class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[][] freq1 = new int[words1.length][26];
        int[] freq2 = new int[26];

        for(int i = 0; i < words1.length; i++){
            String w = words1[i];
            for(int j = 0; j < w.length(); j++){
                int idx = w.charAt(j) - 'a';
                freq1[i][idx]++;
            }
        }

        for(int i = 0; i < words2.length; i++){
            String w = words2[i];
            int[] f = new int[26];
            for(int j = 0; j < w.length(); j++){
                int idx = w.charAt(j) - 'a';
                f[idx]++;
            }

            for(int j = 0; j < 26; j++){
                freq2[j] = Math.max(freq2[j], f[j]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for(int i = 0; i < freq1.length; i++){
            String w = words1[i];
            boolean matched = true;

            for(int j = 0; j < 26; j++){
                if(freq2[j] != 0){
                    if(freq1[i][j] < freq2[j]){
                        matched = false;
                        break;
                    }
                }
            }

            if(matched){
                ans.add(w);
            }
        }

        return ans;
    }
}