class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int N = arr.length;
        int[] dp = new int[arr.length + 1];
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int ans = 1;
        int j = 1  ;
        for(int i = 1; i <= arr.length; i++){
            
            if( i == 1){
                dp[i] = 1;
            }else{
                int k = hm.getOrDefault(arr[i - 1] - difference, -1);

                if(k != -1 ){
                    dp[i] = dp[k] + 1;
                }else{
                    dp[i] = 1;
                }
            }

            hm.put(arr[i - 1], i);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}