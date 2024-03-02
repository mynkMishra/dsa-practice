class Solution {
    LinkedList<String> stack = new LinkedList<String>();
    public int evalRPN(String[] tokens) {
        for(String token: tokens){
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
                stack.addLast(token);
            }else{
                int val = 0;
                int left = 0;
                int right = 0;

                right = Integer.parseInt(stack.removeLast());
                left = Integer.parseInt(stack.removeLast());

                if(token.equals("+")){
                    val = left + right;
                }

                if(token.equals("-")){
                    val = left - right;
                }

                if(token.equals("*")){
                    val = left * right;
                }

                if(token.equals("/")){
                    val = left / right;
                }
                // System.out.println(left + " " + token + " " + right + " = " + val);
                stack.addLast(val + "");

            }
        }

        return Integer.parseInt(stack.getLast());
    }
}