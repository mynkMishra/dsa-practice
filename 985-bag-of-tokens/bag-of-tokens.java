class Solution {
    class Token implements Comparable<Token>{
        int val;
        int idx;

        Token(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Token t){
            return this.val - t.val;
        }
    }
    public int bagOfTokensScore(int[] tokens, int power) {
        List<Integer> list = new ArrayList<Integer>();  

        for(int i = 0; i < tokens.length; i++){
            list.add(tokens[i]);
        }
        Collections.sort(list);

        int start = 0;
        int end = list.size() - 1;
        int score = 0;
        int result = 0;
        while(start <= end){
            System.out.println(power + " " + score + " " + start + " " + end);
            if(1 <= score && list.get(start) > power){
                score--;
                power = power + list.get(end);
                end--;
            }else if(list.get(start) <= power){
                score++;
                power = power - list.get(start);
                start++;
            }else{
                break;
            }
            result = Math.max(result, score);
        }
        System.out.println(power + " " + score + " " + start + " " + end);
        return result;
    }
}