class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        for(int i = low; i <= high; i++){

            int count = 0;
            int num = i;
            int sumT = 0;
            while(num > 0){
                sumT += num%10;
                num = num/10;
                count++;
            }

            if(count%2 == 0){
                int second = i%(int)Math.pow(10, count/2);
                num = second;
                int sumS = 0;
                while(num > 0){
                    sumS += num%10;
                    num = num/10;
                }

                if(sumS == sumT - sumS){
                    ans++;
                }
            }
        }

        return ans;
    }
}