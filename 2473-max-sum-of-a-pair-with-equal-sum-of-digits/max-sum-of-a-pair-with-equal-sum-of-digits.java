class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();

        for(int i = 0; i < nums.length; i++){
            int sum = getDigitsSum(nums[i]);
            if(hm.get(sum) == null){
                hm.put(sum, new ArrayList<Integer>());
            }

            hm.get(sum).add(nums[i]);
        }

        int ans = -1;

        for(Integer key: hm.keySet()){
            List<Integer> numsL = hm.get(key);

            int a = -1;
            int b = -1;

            for(int n: numsL){
                if(n >= b){
                    a = b;
                    b = n;
                }
                else if(n >= a){
                    a = n;
                }
            }
            // System.out.println();

            if(a != -1 && b != -1){
                ans = Math.max(ans, a + b);
            }
        }

        return ans;
    }

    public int getDigitsSum(int num){

        int sum = 0;
        while(num > 0){
            sum += num%10;
            num = num/10;
        }

        return sum;
    }
}