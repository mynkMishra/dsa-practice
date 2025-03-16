class Solution {
    public String reorganizeString(String s) {
        
        int[] map = new int[26];

        for(char ch: s.toCharArray()){
            int idx = ch - 'a';
            map[idx]++;
        }

        PriorityQueue<int[]> maxH = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < map.length; i++){
            if(map[i] != 0){
                maxH.add(new int[]{i, map[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(maxH.size() > 1){
            int[] el1 = maxH.poll();
            int[] el2 = maxH.poll();

            el1[1]--;
            if(el1[1] != 0){
                maxH.add(new int[]{el1[0], el1[1]});
            }
            sb.append((char)(el1[0] + 'a') + "");

            el2[1]--;
            if(el2[1] != 0){
                maxH.add(new int[]{el2[0], el2[1]});
            }
            sb.append((char)(el2[0] + 'a') + "");
        }

        if(maxH.size() > 0 && maxH.peek()[1] == 1){
            sb.append((char)(maxH.peek()[0] + 'a') + "");
            return sb.toString();
        }

        if(maxH.size() == 0){
            return sb.toString();
        }

        return "";
    }
}