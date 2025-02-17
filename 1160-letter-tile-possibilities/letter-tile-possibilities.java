class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<String>();

        solve("", set, new boolean[tiles.length()], tiles);

        return set.size();
    }

    public void solve(String str, Set<String> set, boolean[] used, String tiles){

        for(int i = 0; i < tiles.length(); i++){
            if(!used[i] && !set.contains(str + tiles.charAt(i))){
                set.add(str + tiles.charAt(i));
                used[i] = true;
                solve(str + tiles.charAt(i), set, used, tiles);
                used[i] = false;
            }
        }
    }
}