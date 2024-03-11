class Solution {
    public String customSortString(String order, String s) {
        LinkedList<String> stack = new LinkedList<String>();

        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < s.length(); i++){
            String key = s.substring(i, i + 1);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(int i = 0; i < order.length(); i++){
            String key = order.substring(i, i + 1);
            if(map.get(key) != null){
                for(int j = 0; j < map.get(key); j++){
                    stack.addLast(key);
                }
                map.remove(key);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(stack.size() > 0){
            sb.append(stack.removeFirst());
        }

        for(String key: map.keySet()){
            int i = 0;
            while(i < map.get(key)){
                sb.append(key);
                i++;
            }
            
        }

        return sb.toString();
    }
}