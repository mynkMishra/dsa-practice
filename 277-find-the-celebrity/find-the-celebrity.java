/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {

    int possibleCeleb = 0;
    int candidateCount = -1;
    public int findCelebrity(int n) {
        candidateCount = 0;

        for(int i = 0; i < n; i++){
            if(knows(possibleCeleb, i)){
                possibleCeleb = i;
            }
        }

        for(int i = 0; i < n; i++){
            if(i != possibleCeleb){
                boolean flag = knows(i, possibleCeleb) && !knows(possibleCeleb, i);
                if(!flag){
                    return -1;
                }
            }
        }

        return possibleCeleb;
    }
}