class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int l = 0;
        int r = 0;
        int ans = 0;
        int[] bits = new int[32];

        while(r < nums.length){

            boolean valid = true;
            for(int i = 0; i < 31; i++){
                if((nums[r] & (1 << i)) > 0){
                    bits[i]++;
                }
                if(bits[i] > 1){
                    valid = false;
                }
            }
            r++;

            while(l < nums.length && !valid){
                boolean isValid = true;
                for(int i = 0; i < 31; i++){
                    if((nums[l] & (1 << i)) > 0){
                        bits[i]--;
                    }
                    if(bits[i] > 1){
                        isValid = false;
                    }
                }
                valid = isValid;
                l++;
            }


            ans = Math.max(ans, r - l);
        }

        return ans;
    }
}