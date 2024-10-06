class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String s1;
        String s2;

        if(sentence1.length() < sentence2.length()){
            s1 = sentence1;
            s2 = sentence2;
        }else{
            s1 = sentence2;
            s2 = sentence1;
        }

        String[] str1 = s1.split(" ");

        String[] str2 = s2.split(" ");

        int i1 = 0;
        int j1 = str1.length - 1;

        int i2 = 0;
        int j2 = str2.length - 1;

        while(i1 <= j1){
            if(str1[i1].equals(str2[i2])){
                i1++;
                i2++;
            }else if(str1[j1].equals(str2[j2])){
                j1--;
                j2--;
            }else{
                return false;
            }
        }

        return true;
    }
}