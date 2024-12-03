class Solution {
    public String addSpaces(String s, int[] spaces) {
        int idx = 0;
        String[] words = new String[spaces.length + 1];

        for(int i = 0; i < spaces.length; i++){
            words[i] = s.substring(idx, spaces[i]);
            idx = spaces[i];
        }
        words[words.length - 1] = s.substring(idx, s.length());

        return String.join(" ", words);
    }
}