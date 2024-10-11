class Solution {
    public int maxSumMinProduct(int[] nums) {
        int N = nums.length;

        long[] ps = new long[N + 1];
        ps[0] = 0;
        for(int i = 1; i <= N; i++){
            ps[i] = (long)((long)ps[i - 1] + (long)nums[i - 1]);
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int[] l_b = new int[N];
        for(int i = 0; i < N; i++){
            while(stack.size() > 0 && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }

            if(stack.size() > 0){
                l_b[i] = stack.peek() + 1;
            }else{
                l_b[i] = 0;
            }

            stack.push(i);
        }

        stack.clear();
        int[] r_b = new int[N];
        for(int i = N - 1; i >= 0; i--){
            while(stack.size() > 0 && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }

            if(stack.size() > 0){
                r_b[i] = stack.peek() - 1;
            }else{
                r_b[i] = N - 1;
            }

            stack.push(i);
        }

        int mod = 1000000000 + 7;
        long ans = Long.MIN_VALUE;
        for(int i = 0; i < N; i++){

            int l = l_b[i];
            int r = r_b[i];

            long sum = ps[r + 1] - ps[l];

            ans = Math.max(ans, ((long)nums[i]*sum));
        }

        return (int)(ans%mod);
    }
}