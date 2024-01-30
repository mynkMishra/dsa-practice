class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }

        int l = 0;
        int r = 0;
        int result = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        while(r < s.length()){
            if(map.get(s.charAt(r)) == null){
                map.put(s.charAt(r), r);
                result = Math.max(result, r - l + 1);
            }else{
                if(map.get(s.charAt(r)) < l){
                    map.put(s.charAt(r), r);
                    result = Math.max(result, r - l + 1);
                }else{
                    l = map.get(s.charAt(r)) + 1;
                    map.put(s.charAt(r), r);
                }
            }
            r++;
        }

        return result;
    }
}