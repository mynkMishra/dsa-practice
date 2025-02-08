class Solution {

    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<String>();
        solve(0, 3, new StringBuilder(s));
        return ans;
    }

    public void solve(int idx, int rem, StringBuilder sb){

        if(rem == 0){
            if(isValid(sb.toString().substring(idx, sb.length()))){
                ans.add(sb.toString());
            }
            return;
        }

        for(int i = 0; i < 3 && idx + i < sb.length(); i++){
            if(isValid(sb.toString().substring(idx, idx + i + 1))){
                sb.insert(idx + i + 1, '.');
                solve(idx + i + 2, rem - 1, sb);
                sb.deleteCharAt(idx + i + 1);
            }
        }
    }

    public boolean isValid(String str){
        if(str.length() == 0 || str.length() > 3){
            return false;
        }

        if(str.charAt(0) == '0' && str.length() > 1){
            return false;
        }

        if(Integer.parseInt(str, 10) > 255){
            return false;
        }

        return true;
    }
}