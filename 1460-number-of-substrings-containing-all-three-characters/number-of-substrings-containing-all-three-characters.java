class Solution {
    public int numberOfSubstrings(String s) {
        
        int l = 0;
        int r = 0;
        int ans = 0;
        int[] map = new int[]{0, 0, 0};
        int count = 0;
        
        while(r < s.length()){

            int idx = s.charAt(r) - 'a';
            if(map[idx] == 0){
                count++;
            }
            map[idx]++;
            r++;
            
            if(count == map.length){
                while(l < s.length() && count == map.length){
                    ans += s.length() - r + 1;
                    int idx1 = s.charAt(l) -'a';
                    map[idx1]--;
                    if(map[idx1] == 0){
                        count--;
                    }
                    l++;
                }
            }

        }

        return ans;
    }
}