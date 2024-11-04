class Solution {
    public String compressedString(String word) {

        if(word.length() == 1){
            return "1"+word;
        }
        
        StringBuilder sb = new StringBuilder();
        int N = word.length();
        int count = 1;
        char ch = word.charAt(0);

        for(int i = 1; i < N; i++){
            while(i < N && ch == word.charAt(i)){
                count++;
                i++;
            }

            while(count > 9){
                sb.append("9" + ch);
                count -= 9;
            }
            
            sb.append("" + count + ch);
            if(i < N - 1){
                ch = word.charAt(i);
                count = 1;
            }else if(i == N - 1){
                ch = word.charAt(i);
                count = 1;
                sb.append("" + count + ch);
            }
        }

        return sb.toString();
    }
}