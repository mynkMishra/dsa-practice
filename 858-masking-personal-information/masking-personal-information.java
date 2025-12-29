class Solution {
    public String maskPII(String s) {
        if(isEmail(s)){
            String mid = "";

            mid += Character.toLowerCase(s.charAt(0));
            for(int i = 0; i < 5; i++){
                mid += "*";
            }

            boolean isSep = false;
            char lastCh = '*';

            for(char ch: s.toCharArray()){
                if(ch == '@'){
                    mid += Character.toLowerCase(lastCh);

                    isSep = true;
                }

                if(isSep){
                    if(ch != '.'){
                        mid += Character.toLowerCase(ch);
                    }else{
                        mid += ch;
                    }
                }

                lastCh = ch;
            }

            return mid;
        }else{

            String nums = "";

            for(char ch: s.toCharArray()){
                if(ch - '0' >= 0 && ch - '0' <= 9){
                    nums += ch;
                }
            }

            String ans = "";
            if(nums.length() == 11){
                ans += "+*-";
            }
            if(nums.length() == 12){
                ans += "+**-";
            }
            if(nums.length() == 13){
                ans += "+***-";
            }

            ans += "***-***-";
            
            for(int i = nums.length() - 4; i < nums.length(); i++){
                ans += nums.charAt(i);
            }

            return ans;
        }
    }

    public boolean isEmail(String s){
        for(char ch: s.toCharArray()){
            if(ch == '@'){
                return true;
            }
        }

        return false;
    }
}