class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char ch: s.toCharArray()){
            if(ch == '*'){
                if(!stack.empty()){
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.empty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}