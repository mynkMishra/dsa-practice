class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character, Integer> hm = new HashMap<>();

        for(char ch: tasks){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<int[]> maxH = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(Character ch: hm.keySet()){
            maxH.add(new int[]{ch - 'A', hm.get(ch)});
        }

        int count = 0;
        while(maxH.size() > 0){
            List<int[]> l = new ArrayList<>();

            int q = 0;
            Set<Character> set = new HashSet<>();
            while(q <= n){
                if(!maxH.isEmpty()){
                    int[] el = maxH.poll();

                    if(!set.contains((char)(el[0] + 'A'))){
                        set.add((char)(el[0] + 'A'));
                        el[1]--;
                    }

                    if(el[1] != 0){
                        l.add(el);
                    }
                }
                
                count++;
                q++;
                
                if(l.size() == 0 && maxH.isEmpty()){
                    break;
                }
            }

            for(int[] e: l){
                maxH.add(e);
            }
        }

        return count;
    }
}