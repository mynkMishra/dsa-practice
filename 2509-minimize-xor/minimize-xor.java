class Solution {
    public int minimizeXor(int num1, int num2) {
        int  setCount = 0;

        while(num2 > 0){
            if((num2 & 1) > 0){
                setCount++;
            }

            num2 = num2 >> 1;
        }

        // System.out.println(setCount);
        int ans = 0;
        int i = 30;
        while(i >= 0 && setCount > 0){
            if((num1 & (1 << i)) > 0){
                setCount--;
                ans = (ans | (1 << i));
            }

            i--;
        }

        if(setCount > 0){
            i = 0;
            while(i < 31 && setCount > 0){
                if((ans & (1 << i)) == 0){
                    ans = (ans | (1 << i));
                    setCount--;
                }
                i++;
            }
        }

        return ans;
    }
}