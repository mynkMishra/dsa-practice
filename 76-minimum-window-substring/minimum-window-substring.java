class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()){
            return "";
        }
        
        int N = s.length();
        int M = t.length();
        Map<String, Integer> hms = new HashMap<String, Integer>();
        Map<String, Integer> hmt = new HashMap<String, Integer>();

        for(int i = 0; i < t.length(); i++){
            String str = t.substring(i, i + 1); 
            hmt.put(str, hmt.getOrDefault(str, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int len = 0;
        String res = "";
        int ans = Integer.MAX_VALUE;


        while(r < N){
            if(hms.size() < hmt.size() || len < M){
                String str = s.substring(r, r + 1);
                if(hmt.get(str) != null){
                    hms.put(str, hms.getOrDefault(str, 0) + 1);
                    if(hms.get(str) <= hmt.get(str)){
                        len++;
                    }
                }
                r++;
            }else{
                if(ans > r - l){
                    ans = r - l;
                    res = s.substring(l, r);
                }
                String str = s.substring(l, l + 1);
                if(hms.get(str) != null){
                    hms.put(str, hms.get(str) - 1);
                    if(hms.get(str) < hmt.get(str)){
                        len--;
                    }
                    
                    if(hms.get(str) == 0){
                        hms.remove(str);
                    }
                }

                l++;
            }
        }
        System.out.println(l + " " + r);
        while(hms.size() == hmt.size() && len >= M){
            System.out.println(l + " " + r);
            if(ans > r - l){
                ans = r - l;
                res = s.substring(l, r);
            }
            String str = s.substring(l, l + 1);
            if(hms.get(str) != null){
                hms.put(str, hms.get(str) - 1);
                if(hms.get(str) < hmt.get(str)){
                    len--;
                }
                if(hms.get(str) == 0){
                    hms.remove(str);
                }
            }

            l++;
        }

        return res;

    }
}