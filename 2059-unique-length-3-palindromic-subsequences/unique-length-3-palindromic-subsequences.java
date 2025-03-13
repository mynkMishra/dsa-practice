class Solution {
    public int countPalindromicSubsequence(String s) {

        int N = s.length();
        int[][] map = new int[N][26];
        Map<Integer, List<Integer>> hm = new HashMap<>();

        for(int i = 0; i < 26; i++){
            hm.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            hm.get(idx).add(i);
            for(int j = 0; j < 26; j++){
                if(j == idx){
                    map[i][j] = i == 0 ? 1 : map[i - 1][j] + 1;
                }else{
                    map[i][j] = i == 0 ? 0 : map[i - 1][j];
                }
            }
        }

        Set<String> hs = new HashSet<>();

        for(int k = 0; k < hm.size(); k++){
            List<Integer> idxs = hm.get(k);

            if(idxs.size() > 0){
                for(int i = 1; i < idxs.size(); i++){
                    int l = idxs.get(i - 1);
                    int r = idxs.get(i);

                    if(r - l > 1){
                        for(int j = 0; j < 26; j++){
                            if(k != j && map[r][j] - map[l][j] > 0){
                                String p = (char)(k + 'a') + "" + (char)(j + 'a') + "" + (char)(k + 'a');
                                if(!hs.contains(p)){
                                    hs.add(p);
                                }
                            }
                        }
                    }
                }

                if(idxs.size() > 2){
                    String p = (char)(k + 'a') + "" + (char)(k + 'a') + "" + (char)(k + 'a');
                    if(!hs.contains(p)){
                        hs.add(p);
                    }
                }
            }
        }

        return hs.size();
    }
}