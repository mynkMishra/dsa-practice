class Solution {

    long mod = 1000000000 + 7;
    public int numWays(String[] words, String target) {
        long[][] memo = new long[words[0].length()][target.length()];

        for(long[] m: memo){
            Arrays.fill(m, -1);
        }

        int[][] charFrequency = new int[words[0].length()][26];

        for(int i = 0; i < words[0].length(); i++){

            for(String w: words){
                int ascii = w.charAt(i) - 'a';
                charFrequency[i][ascii]++;
            }
        }

        long ans = getWords(words, target, 0, 0, memo, charFrequency);
        return (int)(ans%mod);
    }

    public long getWords(String[] words, String target, int wordsIndex, int targetIndex, long[][] memo, int[][] charFreq){

        if(targetIndex == target.length()){
            return 1;
        }

        if(wordsIndex == words[0].length()){
            return 0;
        }

        if(memo[wordsIndex][targetIndex] != -1){
            return memo[wordsIndex][targetIndex];
        }

        int currPos = target.charAt(targetIndex) - 'a';

        long skip = getWords(words, target, wordsIndex + 1, targetIndex, memo, charFreq);

        long taken = (long)charFreq[wordsIndex][currPos]*getWords(words, target, wordsIndex + 1, targetIndex + 1, memo, charFreq);

        return memo[wordsIndex][targetIndex] = (taken + skip)%mod;
    }


}