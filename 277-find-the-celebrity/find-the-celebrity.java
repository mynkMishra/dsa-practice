/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int ans = -1;
        int[] indgree = new int[n];
        int[] outdgree = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && knows(i,j)){
                    indgree[j]++;
                    outdgree[i]++;
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(indgree[i] == n - 1 && outdgree[i] == 0){
                ans = i;
                count++;
            }
        }

        if(count > 1){
            return -1;
        }

        return ans;
    }
}