class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int st = meetings[0][0];
        int end = meetings[0][1];

        List<int[]> l = new ArrayList<int[]>();

        for(int i = 1; i < meetings.length; i++){
            if(end < meetings[i][0]){
                l.add(new int[]{st, end});
                st = meetings[i][0];
                end = meetings[i][1];
            }else{
                end = Math.max(end, meetings[i][1]);
            }
        }

        l.add(new int[]{st, end});

        int count = 0;
        for(int[] m: l){
            count += (m[1] - m[0] + 1);
        }

        return days - count;
    }
}