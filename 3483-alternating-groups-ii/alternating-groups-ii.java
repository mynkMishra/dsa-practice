class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        int[] arr = new int[2*colors.length];

        for(int i = 0; i < arr.length; i++){
            arr[i] = colors[i%(colors.length)];
        }
        
        int l = 0;
        int r =  1;
        int ans = 0;

        while(l < colors.length){
            if(r - l < k){
                if(arr[r] == arr[r - 1]){
                    l = r;
                    r++;
                }else{
                    r++;
                }
            }else{
                ans++;
                if(arr[r] == arr[r - 1]){
                    l = r;
                    r++;
                }else{
                    l++;
                    r++;
                }
            }
        }

        return ans;
    }
}