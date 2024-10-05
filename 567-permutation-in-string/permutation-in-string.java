class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int N1 = s1.length();
        int N2 = s2.length();

        Map<Character, Integer> hm1 = new HashMap<Character, Integer>();
        for(int i = 0; i < N1; i++){
            hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> hm2 = new HashMap<Character, Integer>();
        int l = 0;
        int r = 0;

        while(r < N2){
            
            if(r - l < N1){
                char ch = s2.charAt(r);
                hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
                r++;
            }else{

                if(hm1.size() == hm2.size() && compareMap(hm1, hm2)){
                    return true;
                }

                char ch = s2.charAt(l);
                hm2.put(ch, hm2.get(ch) - 1);
                l++;

                if(hm2.get(ch) == 0){
                    hm2.remove(ch);
                }

                char ch1 = s2.charAt(r);
                hm2.put(ch1, hm2.getOrDefault(ch1, 0) + 1);
                r++;
            }
        }
        if(hm1.size() == hm2.size() && compareMap(hm1, hm2)){
            return true;
        }
        return false;
    }

    public boolean compareMap(Map<Character, Integer> hm1, Map<Character, Integer> hm2){

        for(Map.Entry<Character, Integer> e: hm2.entrySet()){
            if(hm1.get(e.getKey()) == null || hm1.get(e.getKey()) > e.getValue()){
                return false;
            }
        }

        return true;
    }
}