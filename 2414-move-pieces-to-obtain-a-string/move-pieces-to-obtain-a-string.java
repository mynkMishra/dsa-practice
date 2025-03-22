class Solution {
    public boolean canChange(String start, String target) {
        int sIdx = 0;
        int tIdx = 0;

        while(sIdx < start.length() && tIdx < target.length()){
            
            if(target.charAt(tIdx) == 'L'){
                while(sIdx < start.length() && start.charAt(sIdx) == '_'){
                    sIdx++;
                }

                if(sIdx == start.length() || start.charAt(sIdx) == 'R'){
                    return false;
                }

                if(tIdx > sIdx){
                    return false;
                }
                sIdx++;
            }else if(target.charAt(tIdx) == 'R'){
                while(sIdx < start.length() && start.charAt(sIdx) == '_'){
                    sIdx++;
                }

                if(sIdx == start.length() || start.charAt(sIdx) == 'L'){
                    return false;
                }

                if(tIdx < sIdx){
                    return false;
                }
                sIdx++;
            }

            tIdx++;
        }

        while(sIdx < start.length()){
            if(start.charAt(sIdx) != '_'){
                return false;
            }
            sIdx++;
        }

        while(tIdx < target.length()){
            if(target.charAt(tIdx) != '_'){
                return false;
            }
            tIdx++;
        }

        return true;
    }
}