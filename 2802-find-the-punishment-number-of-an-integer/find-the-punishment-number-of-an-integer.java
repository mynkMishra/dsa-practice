class Solution {
    public int punishmentNumber(int n) {
        
        int sum = 0;
        for(int i = 1; i <= n; i++){
            boolean flag = solve(i*i, i, new ArrayList<Integer>());
            if(flag){
                sum += i*i;
            }
        }

        return sum;
    }

    public boolean solve(int n, int val, ArrayList<Integer> list){

        if(n == 0){
            int sum = 0;
            for(int el: list){
                sum += el;
            }

            return sum == val;
        }

        int i = 1;
        boolean flag = false;
        while(i <= n){

            list.add(n/i);
            flag = solve(n%i, val, list);
            if(flag){
                return true;
            }
            list.remove(list.size() - 1);

            i = i*10;
        }

        return flag;
    }
}