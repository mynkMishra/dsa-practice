class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        int N = s1.length();
        int i = 0;
        int count = 0;

        while(i < N){
            if(s1.charAt(i) == s2.charAt(i)){
                i++;
            }else{
                if(count == 2){
                    return false;
                }

                int j = N - 1;
                while(j >= 0){
                    if(s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)){
                        count++;
                        break;
                    }
                    j--;
                }

                if(j < 0){
                    return false;
                }

                i++;
            }
        }

        return true;
    }
}