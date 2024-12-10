class Solution {
    public int maximumLength(String s) {
        List<String> list = new ArrayList<String>();

        int N = s.length();
        int l = 0;
        int r = 0;

        Map<String, Integer> hm = new HashMap<String, Integer>();

        int maxLen = -1;
        while(r < N){
            
            while(r + 1 < N && s.charAt(r) == s.charAt(r + 1)){
                r++;
            }

            int len = r - l + 1;
            String p = s.substring(l, r + 1);

            for(int i = 0; i < len; i++){
                String str = p.substring(0, i + 1);
                hm.put(str, hm.getOrDefault(str, 0) + len - i);
                
                
                if(hm.get(str) >= 3){
                    maxLen = Math.max(maxLen, str.length());
                }
            }

            list.add(p);

            r++;
            l = r;
        }

        return maxLen;

    }
}