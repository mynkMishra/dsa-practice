class Solution {

    class Pair{
        char ch;
        int idx;

        Pair(char c, int i){
            ch = c;
            idx = i;
        }
    }

    public String minRemoveToMakeValid(String s) {
        
        int N = s.length();
        Stack<Pair> stack = new Stack<Pair>();

        for(int i = 0; i < N; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                if(stack.size() == 0){
                    stack.push(new Pair(s.charAt(i), i));
                }else{

                    if(s.charAt(i) == ')'){
                        if(stack.peek().ch == '('){
                            stack.pop();
                        }else{
                            stack.push(new Pair(s.charAt(i), i));
                        }
                    }else{
                        stack.push(new Pair(s.charAt(i), i));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = N - 1; i >= 0; i--){
            if(stack.size() != 0 && i == stack.peek().idx){
                stack.pop();
            }else{
                sb.append(s.charAt(i));
            }
        }

        return sb.reverse().toString();
    }
}