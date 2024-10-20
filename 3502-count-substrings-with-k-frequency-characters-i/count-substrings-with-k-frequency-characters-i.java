class Solution {
    public int numberOfSubstrings(String s, int k) {

        int N = s.length();
        HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        int ans = 0;

        for(int i = 0; i < N; i++){
            hm1.clear();
            hm.clear();

            for(int j = i; j < N; j++){
                char ch = s.charAt(j);
                if(hm.get(ch) == null){
                    hm.put(ch, 1);
                    hm1.put(hm.get(ch), hm1.getOrDefault(hm.get(ch), 0) + 1);
                }else{
                    hm1.put(hm.get(ch), hm1.getOrDefault(hm.get(ch), 0) - 1);
                    if(hm1.get(hm.get(ch)) == 0){
                        hm1.remove(hm.get(ch));
                    }
                    hm.put(ch, hm.get(ch) + 1);
                    hm1.put(hm.get(ch), hm1.getOrDefault(hm.get(ch), 0) + 1);
                }

                // System.out.println(hm1);

                if(hm1.get(k) != null){
                    ans += (N - j);
                    break;
                }
            }
            
        }

        return ans;
    }
}