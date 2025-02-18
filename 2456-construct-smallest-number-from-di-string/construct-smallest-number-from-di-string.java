class Solution {

    String ans = "";
    public String smallestNumber(String pattern) {
        solve(0, new boolean[10], "", pattern);

        return ans;
    }

    public void solve(int idx, boolean[] used, String str, String pattern){

        if(idx == pattern.length() + 1){
            if(ans.length() == 0){
                ans = str;
            }

            else if(ans.compareTo(str) > 0){
                ans = new String(str);
            }
            return;
        }
        if(idx != 0){
            int st = Integer.parseInt(str.substring(str.length() - 1, str.length()));
            if(pattern.charAt(idx - 1) == 'I'){
                for(int i = st + 1; i<=9; i++){
                    if(!used[i]){
                        used[i] = true;
                        solve(idx + 1, used, str + i, pattern);
                        used[i] = false;
                    }
                }
            }else{
                for(int i = 1; i<= st - 1; i++){
                    if(!used[i]){
                        used[i] = true;
                        solve(idx + 1, used, str + i, pattern);
                        used[i] = false;
                    }
                }
            }
        }else{
            for(int i = 1; i<=9; i++){
                used[i] = true;
                solve(idx + 1, used, str + i, pattern);
                used[i] = false;
            }
        }
        
    }
}