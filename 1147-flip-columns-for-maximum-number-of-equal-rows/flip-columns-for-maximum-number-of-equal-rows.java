class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for(int i = 0; i < matrix.length; i++){
            String str = "";
            for(int j = 0; j < matrix[0].length; j++){
                str += matrix[i][j];
            }
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        int ans = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> e: hm.entrySet()){
            int count = e.getValue();

            String str = "";
            for(int i = 0; i < e.getKey().length(); i++){
                str += e.getKey().charAt(i) == '0' ? "1" : "0";
            }

            count += hm.get(str) == null ? 0 : hm.get(str);
            ans = Math.max(ans, count);
        }

        return ans;

    }
}