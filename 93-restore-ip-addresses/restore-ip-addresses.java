class Solution {
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<String>();
        solve(0, 3, new ArrayList<String>(), s);
        return ans;
    }

    public void solve(int idx, int k, ArrayList<String> list, String s){

        if(k == 0){
            if(isValid(s.substring(idx, s.length()))){
                list.add(s.substring(idx, s.length()));
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < list.size(); i++){
                    sb.append(list.get(i));
                    if(i != list.size() - 1){
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
                list.remove(list.size() - 1);
            }
            return;
        }

        int i = idx;
        while(i < s.length() && isValid(s.substring(idx, i + 1))){
            list.add(s.substring(idx, i + 1));
            solve(i + 1, k - 1, list, s);
            list.remove(list.size() - 1);
            i++;
        }
    }

    public boolean isValid(String s){
        if(s.length() == 0 || ( s.length() > 1 && s.charAt(0) == '0')){
            return false;
        }
        return (long)0 <= Long.parseLong(s) && Long.parseLong(s) <= (long)255;
    }
}