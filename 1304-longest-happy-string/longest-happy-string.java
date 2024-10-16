class Solution {

    class Pair{
        int count;
        char ch;

        Pair(int count, char ch){
            this.count = count;
            this.ch = ch;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> y.count - x.count);

        if(a > 0){
            pq.add(new Pair(a, 'a'));
        }
        
        if(b > 0){
            pq.add(new Pair(b, 'b'));
        }

        if(c > 0){
            pq.add(new Pair(c, 'c'));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int len = sb.length();
            Pair p = pq.poll();
            int count = p.count;
            char ch = p.ch;

            if(
                len >= 2 && 
                sb.charAt(len - 1) == ch &&
                sb.charAt(len - 2) == ch 
            ){
                if(pq.isEmpty()){
                    break;
                }

                Pair p1 = pq.poll();
                int count1 = p1.count;
                char ch1 = p1.ch;
                sb.append(ch1);
                count1--;

                if(count1 > 0){
                    pq.add(new Pair(count1, ch1));
                }

                pq.add(new Pair(count, ch));
            }else{

                count--;
                sb.append(ch);
                if(count > 0){
                    pq.add(new Pair(count, ch));
                }
            }
        }
        
        return sb.toString();
        
    }
}