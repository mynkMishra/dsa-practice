class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer, Integer> hm = new TreeMap<Integer, Integer>();

        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int max = -1;
        for(int[] el: items ){
            if(el[1] > max){
                max = el[1];
                hm.put(el[0], max);
            }
            hm.put(el[0], max);
        }

        int N = queries.length;
        int[] ans = new int[N];

        for(int i = 0; i < N; i++){
            Map.Entry<Integer, Integer> e = hm.floorEntry(queries[i]);
            ans[i] = e == null ? 0 : e.getValue();
        }

        return ans;
    }
}