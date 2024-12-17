class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];

        for(char ch: s.toCharArray()){
            int ascii = (int)ch - 97;
            freq[ascii]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                pq.add(new int[]{97 + i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            int[] p = pq.poll();

            int count = 0;
            while(p[1] > 0 && count < repeatLimit){
                char ch = (char)(p[0]);
                p[1]--;
                sb.append(ch + "");
                count++;
            }

            if(p[1] > 0 && count == repeatLimit){
                if(pq.size() > 0){
                    int[] np = pq.poll();

                    char ch = (char)(np[0]);
                    np[1]--;
                    sb.append(ch + "");

                    if(p[1] != 0){
                        pq.add(new int[]{p[0], p[1]});
                    }

                    if(np[1] != 0){
                        pq.add(new int[]{np[0], np[1]});
                    }
                }
            }
        }

        return sb.toString();

    }
}