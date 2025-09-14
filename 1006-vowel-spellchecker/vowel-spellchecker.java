class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, String> exactWord = new HashMap<String, String>();
        Map<String, String> lowWord = new HashMap<String, String>();
        Map<String, String> errWord = new HashMap<String, String>();
        String[] res = new String[queries.length];

        for(String word: wordlist){
            exactWord.putIfAbsent(word, word);
            lowWord.putIfAbsent(word.toLowerCase(), word);
            errWord.putIfAbsent(removeVowel(word), word);
        }

        int i = 0;
        for(String query: queries){
            if(exactWord.get(query) != null){
                res[i] = exactWord.get(query);
            }else if(lowWord.get(query.toLowerCase()) != null){
                res[i] = lowWord.get(query.toLowerCase());
            }else if(errWord.get(removeVowel(query)) != null){
                res[i] = errWord.get(removeVowel(query));
            }else{
                res[i] = "";
            }
            i++;
        }

        return res;
    }

    public String removeVowel(String word){
        String res = "";

        for(int i = 0; i < word.length(); i++){
            if(isVowel(Character.toLowerCase(word.charAt(i)))){
                res += '#';
            }else{
                res += Character.toLowerCase(word.charAt(i));
            }
        }

        return res;
    }

    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}