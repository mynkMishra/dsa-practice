class Solution {

    int max = Integer.MIN_VALUE;
    Set<String> seen = new HashSet<String>();
    public int maxUniqueSplit(String s) {
        solve(0, s);
        return max;
    }

    public void solve(int idx, String s){
        if(idx >= s.length()){
            max = Math.max(max, seen.size());
            return;
        }

        for(int i = idx + 1; i <= s.length(); i++){
            if(!seen.contains(s.substring(idx, i))){
                seen.add(s.substring(idx, i));
                solve(i, s);
                seen.remove(s.substring(idx, i));
            }
        }
    }
}