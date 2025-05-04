class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        Map<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < dominoes.length; i++){
            int[] arr = dominoes[i];
            Arrays.sort(arr);
            String key = arr[0] + "#" + arr[1];
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }

        int ans = 0;
        for(String key: hm.keySet()){
            int val = hm.get(key);
            ans += val*(val - 1)/2;
        }

        return ans;
    }
}