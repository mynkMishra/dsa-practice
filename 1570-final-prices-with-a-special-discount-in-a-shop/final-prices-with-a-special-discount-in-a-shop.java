class Solution {
    public int[] finalPrices(int[] prices) {
        LinkedList<Integer> stack = new LinkedList<>();

        int[] ans = new int[prices.length];

        for(int i = prices.length - 1; i >= 0; i--){
            if(stack.size() == 0){
                ans[i] = prices[i];
            }else{
                while(stack.size() > 0 && stack.peekLast() > prices[i]){
                    stack.removeLast();
                }

                if(stack.size() == 0){
                    ans[i] = prices[i];
                }else{
                    ans[i] = prices[i] - stack.peekLast();
                }
            }

            stack.addLast(prices[i]);
        }

        return ans;
    }
}