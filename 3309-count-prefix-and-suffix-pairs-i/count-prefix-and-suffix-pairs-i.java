class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(words[i].length() <= words[j].length() && isPrefixSuffix(words[i], words[j])){
                    ans++;
                }
            }
        }

        return ans;
    }

    public boolean isPrefixSuffix(String pattern, String word){
        
        int i = 0;
        int j = 0;
        while(i < pattern.length() && j < word.length()){
            if(pattern.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j++;
        }

        i = 0;
        j = word.length() - pattern.length();
        while(i < pattern.length() && j < word.length()){
            if(pattern.charAt(i) != word.charAt(j)){
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}