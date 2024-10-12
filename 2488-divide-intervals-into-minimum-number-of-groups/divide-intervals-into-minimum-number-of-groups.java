class Solution {
    public int minGroups(int[][] intervals) {

        long[] ps = new long[1000000 + 2];

        for(int[] in: intervals){
            int st = in[0];
            int end = in[1];

            ps[st]++;
            ps[end + 1]--;
        }

        for(int i = 1; i < ps.length; i++){
            ps[i] = ps[i - 1] + ps[i];
        }

        long ans = Long.MIN_VALUE;
        for(int i = 0; i < ps.length; i++){
            ans = Math.max(ans, ps[i]);
        }

        return (int)ans;
    }
}