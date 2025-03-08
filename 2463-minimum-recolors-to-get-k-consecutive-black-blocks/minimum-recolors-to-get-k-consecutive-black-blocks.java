class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int N = blocks.length();
        int ans = Integer.MAX_VALUE;
        int count = 0;

        int l = 0;
        int r = 0;

        while(r < N){
            if(r - l < k){
                if(blocks.charAt(r) == 'W'){
                    count++;
                }
                r++;
            }else{

                ans = Math.min(ans, count);
                if(blocks.charAt(l) == 'W'){
                    count--;
                }
                l++;

                if(blocks.charAt(r) == 'W'){
                    count++;
                }
                r++;
            }
        }

        ans = Math.min(ans, count);

        return ans;
    }
}