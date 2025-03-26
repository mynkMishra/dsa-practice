class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int m = grid.length;
        int n = grid[0].length;

        if(m*n == 1){
            return 0;
        }

        int rem = -1;
        for(int[] r: grid){
            for(int v: r){
                if(rem == -1){
                    rem = v%x;
                }else if(v%x != rem){
                    return -1;
                }
            }
        }

        for(int[] r: grid){
            for(int v: r){
                if(rem == -1){
                    rem = v%x;
                }else if(v%x != rem){
                    return -1;
                }
            }
        }

        for(int[] r: grid){
            for(int i = 0; i < r.length; i++){
                r[i] -= rem;
            }
        }



        int l = 0;
        int r = -1;
        int max = -1;

        for(int[] row: grid){
            for(int v: row){
                max = Math.max(max, v);
            }
        }

        r = max/x;

        while(l <= r){

            int mid = l + (r - l)/2;

            int ops = check(mid*x, grid, x);

            if((mid == 0 || check((mid - 1)*x, grid, x) > ops) && 
                (mid == (max/x) || ops < check((mid + 1)*x, grid, x))){
                return check(mid*x, grid, x);
            }

            if((mid == 0 || check((mid - 1)*x, grid, x) < ops) && 
                (mid == (max/x) || ops < check((mid + 1)*x, grid, x))){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return check(r*x, grid, x);
    }

    public int check(int val, int[][] grid, int x){
        long total = 0;
        for(int[] row: grid){
            for(int v: row){
                total += (long)Math.abs(val - v);
            }
        }

        return (int)(total/(long)x);
    }
}