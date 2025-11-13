class Solution {
    public int maxOperations(String s) {
        int sum = 0;
        int count = 0;
        boolean flag = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
                if(!flag){
                    flag = true;
                }
            }else{
                if(flag){
                    sum += count;
                    flag = false;
                }
            }
        }

        return sum;
    }
}