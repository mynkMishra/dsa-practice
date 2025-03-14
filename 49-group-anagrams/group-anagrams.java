class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> hm = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            
            String ns = new String(chars);
            if(hm.get(ns) == null){
                hm.put(ns, new ArrayList<String>());
            }

            hm.get(ns).add(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for(List<String> s: hm.values()){
            ans.add(s);
        }

        return ans;
    }
}