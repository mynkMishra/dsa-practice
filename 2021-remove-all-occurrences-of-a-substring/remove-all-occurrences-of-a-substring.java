class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){

            stack.push(s.charAt(i));
            
            if(stack.size() >= part.length() && checkForPart(stack, part)){
                for(int j = 0; j < part.length(); j++){
                    stack.pop();
                }
            } 
        }

        StringBuilder sb = new StringBuilder();

        while(stack.size() > 0){
            sb.append(stack.pop());
        }

        sb.reverse();
        return sb.toString();
    }

    public boolean checkForPart(Stack<Character> stack, String part){
        Stack<Character> stck = new Stack<Character>();
        stck.addAll(stack);

        for(int i = part.length() - 1; i >= 0; i--){
            if(stck.isEmpty() || stck.peek() != part.charAt(i)){
                return false;
            }
            stck.pop();
        }

        return true;
    }
}