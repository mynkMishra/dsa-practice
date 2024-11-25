class Solution {

    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<String>();
        solve(0,0,"",n);

        return list;
    }

    public void solve(int open, int close, String str, int n){
        if(str.length() == 2*n){
            if(open == close){
                list.add(str);
            }
            return;
        }

        if(open >= close){
            solve(open + 1, close, str + "(", n);
        }

        if(close < n){
            solve(open, close + 1, str + ")", n);
        }
    }
}