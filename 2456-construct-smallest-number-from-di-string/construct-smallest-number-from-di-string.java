class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder ans = new StringBuilder();

        for(int idx = 0; idx <= pattern.length(); idx++){
            stack.push(idx + 1);

            if(idx == pattern.length() || pattern.charAt(idx) == 'I'){
                while(!stack.empty()){
                    ans.append(stack.pop());
                }
            }
        }

        return ans.toString();
    }
}