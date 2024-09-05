class Solution {
    public int maxProduct(String[] words) {
        
        List<Integer> list = new ArrayList<Integer>();

        for(String word: words){
            int n = 0;
            for(int i = 0; i < word.length(); i++){
                int idx = 97 - word.charAt(i);
                n = (n | (1 << idx));
            }
            list.add(n);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if((list.get(i) & list.get(j)) == 0){
                    ans = Math.max(ans, words[i].length()*words[j].length());
                }
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}