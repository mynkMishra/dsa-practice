class Solution {
    public String answerString(String word, int numFriends) {

        int N = word.length();
        if(numFriends == 1){
            return word;
        }
        int winSize = word.length() - (numFriends - 1);
        
        String ans = word.substring(0, winSize);
        
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) >= ans.charAt(0)){
                ans = ans.compareTo(word.substring(i, Math.min(i + winSize, N))) < 0 
                    ? word.substring(i, Math.min(i + winSize, N)) : ans;
            }
        }


        return ans;
    }
}