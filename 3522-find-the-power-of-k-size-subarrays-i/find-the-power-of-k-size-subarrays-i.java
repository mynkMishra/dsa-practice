class Solution {
    public int[] resultsArray(int[] nums, int k) {

        if(k == 1){
            return nums;
        }
        
        int N = nums.length;
        int[] ans = new int[N - k + 1];
        Arrays.fill(ans, -1);
        int counter = 1;

        for(int i = 0; i < N - 1; i++){
           
           if(nums[i] + 1 == nums[i + 1]){
            counter++;
           }else{
            counter = 1;
           }

           if(counter >= k){
            ans[i - k + 2] = nums[i + 1];
           }
        }

        return ans;
    }
}