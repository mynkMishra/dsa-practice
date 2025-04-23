class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 1; i <= n; i++){
            int sum = 0;
            int v = i;
            while(v > 0){
                sum += (v%10);
                v = (v - (v%10))/10;
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        int ans = 0;
        for(int k: hm.keySet()){
            ans = Math.max(ans, hm.get(k));
        }

        int count = 0;
        for(int k: hm.keySet()){
            if(hm.get(k) == ans){
                count++;
            }
        }

        return count;
    }
}