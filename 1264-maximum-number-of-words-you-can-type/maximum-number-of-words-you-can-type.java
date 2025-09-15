class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        String[] words = text.split(" ");
        int ans = words.length;

        Set<Character> set = new HashSet<Character>();
        for(char ch: brokenLetters.toCharArray()){
            set.add(ch);
        }

        for(String word: words){
            for(char ch: word.toCharArray()){
                if(set.contains(ch)){
                    ans--;
                    break;
                }
            }
        }

        return ans;
    }
}