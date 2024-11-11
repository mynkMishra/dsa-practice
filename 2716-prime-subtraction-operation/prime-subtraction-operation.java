class Solution {
    public boolean primeSubOperation(int[] nums) {

        int N = nums.length;
        int diff = 0;

        for(int i = 0; i < N; i++){
            int prime = getPrime(nums[i] - diff);
            if(prime == Integer.MIN_VALUE){
                if(i > 0 && nums[i - 1] >= nums[i]){
                    return false;
                }
            }else{
                nums[i] = nums[i] - prime;
            }
            
            diff = nums[i];
            System.out.println(nums[i]);
        }

        for(int i = 1; i < N; i++){
            if(nums[i - 1] >= nums[i]){
                return false;
            }
        }

        return true;
    }

    public void solve(int idx, int[] nums){

    }

    public int getPrime(int num){

        for(int el = num - 1; el > 1; el--){
            boolean isPrime = true;
            for(int i = 2; i <= Math.sqrt(el); i++){
                if(el%i == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                return el;
            }
        }

        return Integer.MIN_VALUE;
    }


}