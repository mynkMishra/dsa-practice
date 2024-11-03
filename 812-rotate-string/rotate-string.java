class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length() != goal.length()){
            return false;
        }

        int N = s.length();

        for(int i = 0; i < N; i++){
            if(s.charAt(i) == goal.charAt(0)){
                String str = s.substring(i, N) + s.substring(0, i);
                if(str.equals(goal)){
                    return true;
                }
            }
        }

        return false;
    }
}