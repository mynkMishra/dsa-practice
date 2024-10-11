class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<Integer[]> list = new ArrayList<Integer[]>();

        Integer[][] t = new Integer[times.length][3];

        for(int i = 0; i < times.length; i++){
            Integer[] a = new Integer[3];
            a[0] = times[i][0];
            a[1] = times[i][1];
            a[2] = i;
            t[i] = a;
        }

        Arrays.sort(t, (a,b) -> a[0] - b[0]);

        for(int i = 0; i < t.length; i++){

            int st = t[i][0];
            int end = t[i][1];

            Integer[] a = new Integer[3];
            a[0] = st;
            a[1] = end;
            a[2] = t[i][2];

            int idx = 0;
            while(idx < list.size()){
                if(list.get(idx)[1] <= st){
                    if(a[2] == targetFriend){
                        return idx;
                    }
                    list.set(idx, a);
                    break;
                }
                idx++;
            }

            if(idx == list.size()){
                if(a[2] == targetFriend){
                    return idx;
                }
                list.add(a);
            }
            
        }

        return times.length - 1;
    }
}