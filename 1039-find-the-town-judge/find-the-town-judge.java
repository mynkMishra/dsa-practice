class Solution {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> set = new HashSet<Integer>();
        int[] count = new int[n + 1];

        for(int[] arr : trust){
            int a = arr[0];
            int b = arr[1];
            set.add(a);
            count[b]++;
        }

        for(int i = 1; i<= n; i++){
            if(!set.contains(i) && count[i] == n -1){
                return i;
            }
        }

        return -1;
    }
}