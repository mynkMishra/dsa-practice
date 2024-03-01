class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for(int i = 0; i < s.length(); i++){
            // if(s.charAt(i) == '('){
            //     stack.addLast('(');
            // }
            // else if(s.charAt(i) == '{'){
            //     stack.addLast('{');
            // }
            // else if(s.charAt(i) == '['){
            //     stack.addLast('[');
            // }

            // else 
            if(s.charAt(i) == ')' && stack.size() > 0 && stack.getLast() == '('){
                stack.removeLast();
            }
            else if(s.charAt(i) == '}' && stack.size() > 0 && stack.getLast() == '{'){
                stack.removeLast();
            }
            else if(s.charAt(i) == ']' && stack.size() > 0 && stack.getLast() == '['){
                stack.removeLast();
            }else{
                stack.addLast(s.charAt(i));
            }
        }

        return stack.size() == 0;
    }
}