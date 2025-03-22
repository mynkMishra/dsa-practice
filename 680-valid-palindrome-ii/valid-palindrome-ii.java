class Solution {
    public boolean validPalindrome(String s) {
        
        int l = 0;
        int r = s.length() - 1;
        int count = 0;

        while(l <= r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                if(count > 0){
                    return false;
                }else {
                    count++;
                    return check(l, r - 1, s) || check(l + 1, r, s);
                }
            }
        }

        return true;
    }

    public boolean check(int l, int r, String s){

        while(l <= r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }

        return true;
    }
}