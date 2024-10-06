class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        int N = intervals.length;
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();

        for(int i = 0; i < N; i++){
            int[] r = intervals[i];
            tm.put(r[0], i);
        }

        int[] res = new int[N];
        for(int i = 0; i < N; i++){
            Integer e = tm.ceilingKey(intervals[i][1]);
            res[i] = e == null ? -1 : tm.get(e);
        }

        return res;
    }
}