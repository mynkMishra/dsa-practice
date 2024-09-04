class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for(int el: nums){
            xor = xor^el;
        }

        int idx = 0;
        while(((xor >> idx) & 1) == 0){
            idx++;
        }

        int a = 0;
        int b = 0;
        for(int el: nums){
            if(((el >> idx) & 1) > 0){
                a = a ^ el;
            }else{
                b = b ^ el;
            }
        }

        int[] r = new int[2];
        r[0] = a;
        r[1] = b;
        return r;
    }
}