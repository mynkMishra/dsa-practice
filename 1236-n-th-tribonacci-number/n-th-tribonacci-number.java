class Solution {

    int[] store;
    public int tribonacci(int n) {
        store = new int[n + 1];
        Arrays.fill(store, -1);
        return sum(n);
    }

    public int sum(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }

        if(store[n] != -1){
            return store[n];
        }

        store[n] = sum(n - 3) + sum(n - 2) + sum(n -1);

        return store[n];
    }
}