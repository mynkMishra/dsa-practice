class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<String>();

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int[] lps = computeLPSArray(word);

            for(int j = 0; j < words.length; j++){
                if(i != j){
                    if(isSubstringOf(word, words[j], lps)){
                        ans.add(word);
                        break;
                    }
                }
            }
        }

        return ans;
    }

    private boolean isSubstringOf(String sub,String main, int[] lps){
        int mainIndex = 0;
        int subIndex = 0;

        while(mainIndex < main.length()){
            if(main.charAt(mainIndex) == sub.charAt(subIndex)){
                mainIndex++;
                subIndex++;

                if(subIndex == sub.length()){
                    return true;
                }
            }else{
                if(subIndex > 0){
                    subIndex = lps[subIndex - 1];
                }else{
                    mainIndex++;
                }
            }
        }

        return false;
    }

    private int[] computeLPSArray(String sub){
        int[] lps = new int[sub.length()];

        int currIndex = 1;
        int len = 0;

        while(currIndex < sub.length()){
            if(sub.charAt(currIndex) == sub.charAt(len)){
                len++;
                lps[currIndex] = len;
                currIndex++;
            }else{
                if(len > 0){
                    len = lps[len - 1];
                }else{
                    currIndex++;
                }
            }
        }

        return lps;
    }
}