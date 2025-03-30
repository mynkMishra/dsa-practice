class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];

        for(char ch: s.toCharArray()){
            int idx = ch - 'a';

            map[idx]++;
        }

        Set<Character> hs = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        int count = 0;
        int start = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            
            hs.add(ch);
            map[idx]--;
            
            if(map[idx] == 0){
                count++;
            }

            if(hs.size() == count){
                ans.add(i - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }
}