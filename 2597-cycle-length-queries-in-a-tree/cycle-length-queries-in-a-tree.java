class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        
        int N = queries.length;
        int[] res = new int[N];

        for(int i = 0; i < N; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            // System.out.println(a + " " + b);
            res[i] = findLca(a, b, 0) + 1;
        }

        return res;
    }

    public int findLca(int a, int b, int steps){

        if(a == b){
            return steps;
        }

        if(a > b){
            int an = a%2 == 0 ? a/2 : (a - 1)/2;
            return findLca(an, b, steps + 1);
        }else{
            int bn = b%2 == 0 ? b/2 : (b - 1)/2;
            return findLca(a, bn, steps + 1);
        } 
    }
    
}