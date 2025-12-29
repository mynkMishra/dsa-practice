class Solution {
    public boolean detectCapitalUse(String word) {
        
        int count = 0;

        for(char ch: word.toCharArray()){
            boolean isCaps = ch - 'A' >= 0 && ch - 'A' <= 25;
            if(isCaps){
                count++;
            }
        }

        boolean isFirstCapOnly = count == 1 && word.charAt(0) - 'A' >= 0 && word.charAt(0) - 'A' <= 25;
        return count == 0 || isFirstCapOnly || count == word.length();
    }
}