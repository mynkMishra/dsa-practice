class Solution {
    public int totalFruit(int[] fruits) {
        
        int N = fruits.length;
        int l = 0;
        int r = 0;

        int type_a = -1;
        int type_b = -1;

        int count_a = 0;
        int count_b = 0;

        int res = Integer.MIN_VALUE;

        while(r < N){

            res = Math.max(res, count_a + count_b);
            if(type_a == -1){
                type_a = fruits[r];
                count_a++;
                r++;
            }else if(type_b == -1){
                if(fruits[r] == type_a){
                    count_a++;
                    r++;
                }else{
                    type_b = fruits[r];
                    count_b++;
                    r++;
                }
            }else{
                if(fruits[r] == type_a){
                    count_a++;
                    r++;
                }else if(fruits[r] == type_b){
                    count_b++;
                    r++;
                }else{
                    if(fruits[l] == type_a){
                        while(fruits[l] == type_a){
                            count_a--;
                            l++;
                        }

                        if(count_a == 0){
                            type_a = fruits[r];
                            count_a++;
                            r++;
                        }
                    }else{
                        while(fruits[l] == type_b){
                            count_b--;
                            l++;
                        }

                        if(count_b == 0){
                            type_b = fruits[r];
                            count_b++;
                            r++;
                        }
                    }

                }
            }
        }

        res = Math.max(res, count_a + count_b);
        return res;
    }
}