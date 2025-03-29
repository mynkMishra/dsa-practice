class Solution {

    int[] prefixSum;
    int sum;
    public Solution(int[] w) {
        
        prefixSum = new int[w.length];
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            if(i == 0){
                prefixSum[i] = w[i];
            }else{
                prefixSum[i] = prefixSum[i - 1] + w[i];
            }
        }
    }
    
    public int pickIndex() {
        
        int target = (int)((double)sum*Math.random());
        int l = 0;
        int h = prefixSum.length - 1;

        while(l <= h){
            int mid = l + (h - l)/2;

            if(target < prefixSum[mid]){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */