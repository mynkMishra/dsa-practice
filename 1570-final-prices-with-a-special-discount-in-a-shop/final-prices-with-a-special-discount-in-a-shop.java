class Solution {
    public int[] finalPrices(int[] prices) {

        int N = prices.length;
        Stack<Integer> stack = new Stack<Integer>();

        int[] ans = new int[N];

        for(int i = N - 1; i >= 0; i--){
            if(stack.size() == 0){
                ans[i] = N;
                stack.push(i);
            }else{
                while(stack.size() > 0 && prices[stack.peek()] > prices[i]){
                    stack.pop();
                }

                if(stack.size() == 0){
                    ans[i] = N;
                    stack.push(i);
                }else{
                    ans[i] = stack.peek();
                    stack.push(i);
                }
            }
        }

        for(int i = 0; i < N; i++){
            int j = ans[i];
            ans[i] = j == N ? prices[i] : prices[i] - prices[j];
        }

        return ans;
    }
}