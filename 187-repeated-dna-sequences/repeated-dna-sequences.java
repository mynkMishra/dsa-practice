class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        int N = s.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<String, Integer>();

        while(j < N){
            if(j - i < 10){
                sb.append(s.charAt(j));
                j++;
            }else{
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                sb.deleteCharAt(0);
                i++;

                sb.append(s.charAt(j));
                j++;
            }
        }
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

        List<String> res = new ArrayList<String>();
        for(Map.Entry<String, Integer> e: map.entrySet()){
            if(e.getValue() > 1){
                res.add(e.getKey());
            }
        }

        return res;
    }
}