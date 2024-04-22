class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int start = 0;
        int end = 0;
        
        int tCount= 0;
        int fCount = 0;

        int ans = Integer.MIN_VALUE;

        while(end < answerKey.length()){
            if(tCount <= k || fCount <= k){
                ans = Math.max(ans, tCount + fCount);
                if(answerKey.charAt(end) == 'T'){
                    tCount++;
                }else{
                    fCount++; 
                }
                end++;
            }else{
                while(start < answerKey.length() && tCount > k && fCount > k){
                    if(answerKey.charAt(start) == 'T'){
                        tCount--;
                    }else{
                       fCount--; 
                    }
                    start++;
                }
            }
        }

        if(tCount <= k || fCount <= k){
            ans = Math.max(ans, tCount + fCount);
        }
        
        return ans;
    }
}