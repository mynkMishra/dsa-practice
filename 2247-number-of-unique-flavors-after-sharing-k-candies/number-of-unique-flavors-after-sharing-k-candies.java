class Solution {
    public int shareCandies(int[] candies, int k) {
        
        if(candies.length == k){
            return 0;
        }

        Map<Integer, Integer> aux = new HashMap<Integer, Integer>();
        for(int el: candies){
            aux.put(el, aux.getOrDefault(el, 0) + 1);
        }
        int unique = aux.size();

        int l = 0;
        int r = 0;
        int N = candies.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int ans = Integer.MIN_VALUE;

        while(r < N){
            if(r < k){
                aux.put(candies[r], aux.getOrDefault(candies[r], 0) - 1);
                 if(aux.get(candies[r]) == 0){
                    aux.remove(candies[r]);
                }
                r++;
            }else{
                ans = Math.max(ans, aux.size());
                aux.put(candies[l], aux.getOrDefault(candies[l], 0) + 1);
                l++;

                aux.put(candies[r], aux.getOrDefault(candies[r], 0) - 1);
                if(aux.get(candies[r]) == 0){
                    aux.remove(candies[r]);
                }
                r++;
            }
        }

        ans = Math.max(ans, aux.size());

        return ans;
    }
}