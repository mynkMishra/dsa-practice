class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int N = heroes.length;
        int M = monsters.length;

        Long[][] arr = new Long[M][2];
        arr[0][0] = (long)monsters[0];
        arr[0][1] = (long)coins[0];

        for(int i = 1; i < M; i++){
            arr[i][0] = (long)monsters[i];
            arr[i][1] = (long)coins[i];
        }

        Arrays.sort(arr, (a,b) -> (int)(a[0] - b[0]));

        for(int i = 1; i < M; i++){
            arr[i][1] = (long)((long)arr[i - 1][1] + (long)arr[i][1]);
        }

        long[] ans = new long[N]; 
        for(int i = 0; i < heroes.length; i++){
            int hero = heroes[i];
            if(hero < arr[0][0]){
                ans[i] = 0;
            }else if(hero > arr[M - 1][0]){
                ans[i] = arr[M - 1][1];
            }else{
                int l = 0;
                int r = M - 1;
                int res = 0;
                while(l<=r){
                    int mid = l + (r - l)/2;

                    if(hero < arr[mid][0]){
                        r = mid - 1;
                    }else{
                        res = mid;
                        l = mid + 1;
                    }
                }

                ans[i] = arr[res][1];
            }
        }

        return ans;
    }
}