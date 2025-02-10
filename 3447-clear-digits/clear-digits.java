class Solution {
    public String clearDigits(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();

        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if(idx >= 0 && idx <= 25){
                stack.addLast(ch);
            }else{
                stack.removeLast();
            }
            i++;
        }

        String str = "";
        while(stack.size() > 0){
            str += stack.removeFirst();
        }

        return str;
    }
}