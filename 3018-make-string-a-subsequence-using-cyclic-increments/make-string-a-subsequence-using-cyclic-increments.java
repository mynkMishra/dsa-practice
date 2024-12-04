class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        
        int p1 = 0;
        int p2 = 0;

        while(p1 < l1 && p2 < l2){
            char ch = str1.charAt(p1) == 'z' ? 'a' : (char)((int)str1.charAt(p1) + 1);
            if(str1.charAt(p1) == str2.charAt(p2) || ch == str2.charAt(p2)){
                p2++;
            }
            p1++;
        }

        if(p2 == l2){
            return true;
        }

        return false;
    }
}