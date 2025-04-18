class Solution {
    public String countAndSay(int n) {
        return solve(n);
    }

    public String solve(int n){

        if(n == 1){
            return "1";
        }

        String str = solve(n - 1);

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < str.length()){
            int count = 1;
            char ch = str.charAt(i);
            while(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)){
                i++;
                count++;
            }

            sb.append(count + "" + ch);
            i++;
        }

        return sb.toString();
    }

}