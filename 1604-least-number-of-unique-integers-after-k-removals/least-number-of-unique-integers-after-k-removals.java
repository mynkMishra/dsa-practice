class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] freq = new int[100001];

        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            freq[e.getValue()]++;
        }

        int i = 1;
        while(k > 0) {
            if(freq[i]*i <= k){
                k = k - (freq[i]*i);
                freq[i] = 0;
                i++;
            }else{
                freq[i] = freq[i] -  (k/i);
                k = 0;
            }
        }

        int result = 0;
        for(i = 1; i < freq.length; i++){
            if(freq[i] > 0){
                result = result + freq[i] ;
            }
        }

        return result;
    }
}