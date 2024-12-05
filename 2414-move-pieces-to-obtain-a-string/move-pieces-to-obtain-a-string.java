class Solution {
    public boolean canChange(String start, String target) {
        
        int startIdx = 0;
        int targetIdx = 0;

        while(startIdx < start.length() && targetIdx < target.length()){

            while(startIdx < start.length() && start.charAt(startIdx) == '_'){
                startIdx++;
            }

            while(targetIdx < target.length() && target.charAt(targetIdx) == '_'){
                targetIdx++;
            }

            if(startIdx == start.length() || targetIdx == target.length()){
                return startIdx == start.length() && targetIdx == target.length();
            }

            if(start.charAt(startIdx) == target.charAt(targetIdx)){
                if(start.charAt(startIdx) == 'L' && startIdx < targetIdx){
                    return false;
                }

                if(start.charAt(startIdx) == 'R' && startIdx > targetIdx){
                    return false;
                }

                startIdx++;
                targetIdx++;

            }else{
                return false;
            }
        }

        while(startIdx < start.length() && start.charAt(startIdx) == '_'){
            startIdx++;
        }

        while(targetIdx < target.length() && target.charAt(targetIdx) == '_'){
            targetIdx++;
        }

        if(startIdx != start.length() || targetIdx != target.length()){
            return false;
        }

        return true;
    }
}