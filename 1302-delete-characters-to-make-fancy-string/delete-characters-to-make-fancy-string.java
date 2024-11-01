class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(sb.length() < 2){
                sb.append(s.charAt(i));
            }else{
                int len = sb.length();
                boolean eq = sb.charAt(len - 2) == s.charAt(i) && sb.charAt(len - 1) == s.charAt(i);
                if(!eq){
                    sb.append(s.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}