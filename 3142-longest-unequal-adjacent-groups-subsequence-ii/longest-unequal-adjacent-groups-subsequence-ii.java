class Solution {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        Map<String, List<Integer>> memo = new HashMap<>();

        List<Integer> list = solve(-1, 0, words, groups, memo);
        Collections.reverse(list);

        List<String> ans = new ArrayList<>();
        for(int i: list){
            ans.add(words[i]);
        }

        return ans;
    }

    public List<Integer> solve(int prev, int idx, String[] words, int[] groups, Map<String, List<Integer>> memo){

        if(idx >= words.length){
            return new ArrayList<Integer>();
        }

        String key = idx + " " + prev;

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        List<Integer> take = new ArrayList<>();
        if(prev == -1 || 
            (groups[prev] != groups[idx] && checkHamDist(words[prev], words[idx]))){
            take = new ArrayList<>(solve(idx, idx + 1, words, groups, memo));
            take.add(idx);
        }

        List<Integer> skip = solve(prev, idx + 1, words, groups, memo);

        if(skip.size() > take.size()){
            memo.put(key, skip);
        }else{
            memo.put(key, take);
        }

        return memo.get(key);
    }

    public boolean checkHamDist(String a, String b){
        if(a.length() != b.length()){
            return false;
        }

        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
        }

        return diff == 1;
    }
}