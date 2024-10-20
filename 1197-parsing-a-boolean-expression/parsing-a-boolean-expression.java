class Solution {
    public boolean parseBoolExpr(String exp) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> stackOp = new Stack<Character>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            if(ch == '&' || ch == '!' || ch == '|'){
                stackOp.push(ch);
            }else if(ch == '('){
                stack.push('(');
            }else if(ch == 't' || ch == 'f'){
                stack.push(ch);
            }else if(ch == ')'){
                int ans = stack.pop() == 't' ? 1 : 0;
                Character op = stackOp.pop();
                if(op == '!'){
                    stack.pop();
                    stack.push(ans == 0 ? 't' : 'f');
                }else{
                    while(stack.peek() != '('){
                        int val = stack.pop() == 't' ? 1 : 0;
                        if(op == '&'){
                            ans = (ans & val);
                        }else if(op == '|'){
                            ans = (ans | val);
                        }
                    }
                    stack.pop();
                    stack.push(ans == 1 ? 't' : 'f');
                }
            }
        }

        return stack.pop() == 't';
    }
}