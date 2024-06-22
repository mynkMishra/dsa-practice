class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int lo = 0;

        while(lo < arr.length - 1 && arr[lo] <= arr[lo + 1]){
            lo++;
        }

        if(lo == arr.length - 1){
            return 0;
        }

        int hi = arr.length - 1;

        while(hi > 0 && arr[hi - 1] <= arr[hi]){
            hi--;
        }

        if(hi == 0){
            return 0;
        }

        int low = 0;
        int high = hi;
        int result = Math.min(hi, arr.length - lo - 1);

        while(low <= lo && high < arr.length){
            if(arr[low] <= arr[high]){
                low++;
            }else{
                high++;
            }
            result = Math.min(result, high - low);
        }

        return result;
    }
}