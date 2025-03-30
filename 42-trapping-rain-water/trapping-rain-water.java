class Solution {
    public int trap(int[] height) {
        
        int N = height.length;
        int[] ngl = new int[N];

        LinkedList<Integer> stack = new LinkedList<>();

        for(int i = 0; i < N; i++){
            if(stack.size() == 0){
                ngl[i] = -1;
                stack.addLast(i);
            }else{
                while(stack.size() > 0 && height[stack.peekLast()] <= height[i]){
                    stack.removeLast();
                }

                if(stack.size() == 0){
                    ngl[i] = -1;
                    stack.addLast(i);
                }else{
                    ngl[i] = stack.peekLast();
                }
            }
        }

        stack.clear();

        int[] ngr = new int[N];

        for(int i = N - 1; i >= 0; i--){
            if(stack.size() == 0){
                ngr[i] = N;
                stack.addLast(i);
            }else{
                while(stack.size() > 0 && height[stack.peekLast()] <= height[i]){
                    stack.removeLast();
                }

                if(stack.size() == 0){
                    ngr[i] = N;
                    stack.addLast(i);
                }else{
                    ngr[i] = stack.peekLast();
                }
            }
        }

        int sum = 0;

        for(int i = 0; i < N; i++){
            System.out.println(ngl[i]);
            if(ngl[i] != -1 && ngr[i] != N){
                sum += (Math.min(height[ngr[i]], height[ngl[i]]) - height[i]);
            }
        }

        return sum;
    }
}