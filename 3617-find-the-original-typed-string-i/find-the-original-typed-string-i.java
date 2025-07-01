class Solution {
    public int possibleStringCount(String word) {
        int count = 0;
        int ans = 0;

        int[] arr = new int[26];

        for(int i = 0; i < word.length(); i++){
            if(i == 0){
                count = 1;
            }else{
                if(word.charAt(i - 1) == word.charAt(i)){
                    count++;
                }else{
                    if(count > 1){
                        ans += (count - 1);
                    }
                    count = 1;
                }
            }
        }

        if(count > 1){
            ans += count - 1;
        }

        return ans == 0 ? 1 : ans + 1;
    }
}