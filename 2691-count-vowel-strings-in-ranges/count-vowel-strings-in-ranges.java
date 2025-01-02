class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int N = words.length;
        int[] prefixSum = new int[N];
        Set<Character> hs = new HashSet<Character>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');

        for(int i = 0; i < words.length; i++){
            String w = words[i];
            if(i == 0){
                if(hs.contains(w.charAt(0)) && hs.contains(w.charAt(w.length() - 1))){
                    prefixSum[i] = 1;
                }
            }else{
                if(hs.contains(w.charAt(0)) && hs.contains(w.charAt(w.length() - 1))){
                    prefixSum[i] = prefixSum[i - 1] + 1;
                }else{
                    prefixSum[i] = prefixSum[i - 1];
                }
            }
        }

        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l == 0){
                ans[i] = prefixSum[r];
            }else{
                ans[i] = prefixSum[r] - prefixSum[l - 1];
            }
        }

        return ans;
    }
}