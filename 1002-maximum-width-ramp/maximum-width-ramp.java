class Solution {

    class Node{
        int val;
        int idx;

        Node(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    public int maxWidthRamp(int[] nums) {
        
        int N = nums.length;
        Stack<Node> stack = new Stack<Node>();

        for(int i = 0; i < N; i++){
            if(stack.size() == 0 || nums[i] < stack.peek().val){
                stack.push(new Node(nums[i], i));
            }
        }

        int ans = 0;
        for(int i = N - 1; i >= 0; i--){
            while(stack.size() > 0 && nums[i] >= stack.peek().val){
                Node node = stack.peek();
                ans = Math.max(ans, i - node.idx);
                stack.pop();
            }
        }

        return ans;
    }
}