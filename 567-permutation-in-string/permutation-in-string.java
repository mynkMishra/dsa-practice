class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int N = s2.length();
        int l = 0;
        int r = 0;
        int k = s1.length();
        int t = 97;

        int target = 0;
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();

        for(int i = 0; i < s1.length(); i++){
            target += (t - s1.charAt(i));
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int sum = 0;

        while(r < N){

            if(sum == target){
                boolean match = true;
                for(Map.Entry<Character, Integer> e: map1.entrySet()){
                    boolean exists = e.getValue() == (map2.get(e.getKey()) == null ? -1 : map2.get(e.getKey()));
                    match = match && exists;                
                }

                if(match){
                    return true;
                }
            }
            if(r < k){
                sum += (t - s2.charAt(r));
                map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0) + 1);
                r++;
            }else{
                sum -= (t - s2.charAt(l));
                map2.put(s2.charAt(l), map2.get(s2.charAt(l)) - 1);
                l++;

                sum += (t - s2.charAt(r));
                map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0) + 1);
                r++;
            }
        }

        if(sum == target){
            boolean match = true;
            for(Map.Entry<Character, Integer> e: map1.entrySet()){
                boolean exists = e.getValue() == (map2.get(e.getKey()) == null ? -1 : map2.get(e.getKey()));
                match = match && exists;
            }

            if(match){
                return true;
            }
        }

        return false;
    }
}