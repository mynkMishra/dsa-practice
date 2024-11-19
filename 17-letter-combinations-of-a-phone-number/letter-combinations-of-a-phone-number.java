class Solution {
    Map<String, List<String>> hm;
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        hm = new HashMap<String, List<String>>();
        ans = new ArrayList<String>();

        if(digits.length() == 0){
            return ans;
        }

        List<String> list = List.of("a","b","c");
        hm.put("2", list);

        list = List.of("d","e","f");
        hm.put("3",list);

        list = List.of("g","h","i");
        hm.put("4",list);

        list = List.of("j","k","l");
        hm.put("5",list);

        list = List.of("m","n","o");
        hm.put("6",list);

        list = List.of("p","q","r","s");
        hm.put("7",list);

        list = List.of("t","u","v");
        hm.put("8",list);

        list = List.of("w","x","y","z");
        hm.put("9",list);

        solve(0, "", digits);

        return ans;
    }

    public void solve(int idx, String word, String digits){

        if(idx == digits.length()){
            ans.add(word);
            return;
        }

        for(String str: hm.get(digits.substring(idx, idx + 1))){
            solve(idx + 1, word + str, digits);
        }            
    }
}