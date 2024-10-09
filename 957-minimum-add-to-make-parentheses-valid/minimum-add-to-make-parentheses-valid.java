class Solution {
    public int minAddToMakeValid(String s) {
        
        LinkedList<Character> stack = new LinkedList<Character>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.addLast('(');
            }else if(s.charAt(i) == ')'){
                if(stack.size() > 0 && stack.peekLast() == '('){
                    stack.removeLast();
                }else{
                    stack.add(s.charAt(i));
                }
            }
        }

        return stack.size();
    }
}