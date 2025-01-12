class Solution {
    public boolean canBeValid(String s, String locked) {

        if(s.length()%2 != 0){
            return false;
        }
        Stack<Integer> openedBrackets = new Stack<Integer>();
        Stack<Integer> unlocked = new Stack<Integer>();

        for(int i = 0; i < s.length(); i++){
            if(locked.charAt(i) == '0'){
                unlocked.push(i);
            }else if(s.charAt(i) == '('){
                openedBrackets.push(i);
            }else if(s.charAt(i) == ')'){
                if(!openedBrackets.empty()){
                    openedBrackets.pop();
                }else if(!unlocked.empty()){
                    unlocked.pop();
                }else{
                    return false;
                }
            }
        }

        while(!openedBrackets.empty() && 
        !unlocked.empty() && 
        (int)openedBrackets.peek() < (int)unlocked.peek()){
            openedBrackets.pop();
            unlocked.pop();
        }

        if(!openedBrackets.empty()){
            return false;
        }

        return true;
    }
}