class Solution {
    public int minimumRounds(int[] tasks) {

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int t: tasks){
            hm.put(t, hm.getOrDefault(t, 0) + 1);
        }

        int[] freq = new int[hm.size()];

        int i = 0;
        for(Map.Entry<Integer, Integer> e: hm.entrySet()){
            freq[i] = e.getValue();
            i++;
        }

        for(int f: freq){
            if(f == 1){
                return -1;
            }
        }

        return dp(0, freq);
    }

    public int dp(int idx, int[] freq){

        if(idx == freq.length){
            return 0;
        }

        int round = freq[idx]/3;
        freq[idx] = freq[idx]%3;
        round+= freq[idx] == 1 || freq[idx] == 2 ? 1 : 0;
        

        int val = dp(idx + 1, freq);

        return val + round;

    }
}