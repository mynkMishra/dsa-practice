class Solution {
    public int maxArea(int[] height) {
        
        int l = 0;
        int r = height.length - 1;
        int max = Integer.MIN_VALUE;

        while(l < r){
            int x = r - l;
            int y = Math.min(height[l], height[r]);
            max = Math.max(x*y, max);

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }

        return max;
    }
}