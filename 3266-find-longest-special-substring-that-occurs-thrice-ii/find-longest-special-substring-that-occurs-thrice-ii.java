class Solution {
    public int maximumLength(String s) {
        int N = s.length();

        int l = 0;
        int r = 0;

        int maxLen = -1;
        List<String> list = new ArrayList<String>();
        Map<String, Integer> hm = new HashMap<String, Integer>();

        while(r < N){
            
            while(r + 1 < N && s.charAt(r) == s.charAt(r + 1)){
                r++;
            }

            int len = r - l + 1;
            if(len <= 3){
                String str = s.substring(l, r + 1);
                for(int i = 0; i < len; i++){
                    String p = str.substring(0, i + 1);
                    hm.put(p, hm.getOrDefault(p, 0) + len - i);

                    if(hm.get(p) >= 3){
                        maxLen = Math.max(maxLen, p.length());
                    }
                }
            }else{
                maxLen = Math.max(maxLen, len - 2);

                String str = s.substring(l, r + 1);
                for(int i = len - 2; i < len; i++){
                    String p = str.substring(0, i + 1);
                    hm.put(p, hm.getOrDefault(p, 0) + len - i);

                    if(hm.get(p) >= 3){
                        maxLen = Math.max(maxLen, p.length());
                    }
                }
            }

            r++;
            l = r;
        }

        return maxLen;
    }
}