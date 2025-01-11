class Solution {
    public boolean canConstruct(String s, int k) {

        if(s.length() < k){
            return false;
        }

        int[] freq = new int[26];

        for(char ch: s.toCharArray()){
            int idx = ch - 'a';
            freq[idx]++;
        }

        int count = 0;
        for(int f: freq){
            if(f%2 != 0){
                count++;
            }
        }

        if(count > k){
            return false;
        }

        return true;


    }
}