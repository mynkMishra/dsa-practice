class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);

        Set<Integer> hs = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 0){
                for(int j = 0; j < digits.length; j++){
                    if(i != j){
                        for(int k = 0; k < digits.length; k++){
                            if(j != k && i != k){
                                int num = digits[i]*100 + digits[j]*10 + digits[k];
                                if(num%2 == 0 && !hs.contains(num)){
                                    hs.add(num);
                                    list.add(num);
                                }
                            }
                        }
                    }
                }
            }
        }

        int[] res = new int[list.size()];

        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}