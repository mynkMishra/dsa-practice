class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int mod = 1000000000 + 7;

        int count = 0;
        int prefixSum = 0;
        int evenCount = 1;
        int oddCount = 0;

        for(int i = 0; i < arr.length; i++){
            prefixSum += arr[i];

            if(prefixSum%2 == 0){
                count += oddCount;
                evenCount++;
            }else{
                count += evenCount;
                oddCount++;
            }

            count = count%mod;
        }

        return count%mod;

    }
}