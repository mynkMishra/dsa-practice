class Solution {
    public int maxJump(int[] stones) {
        
        int l = 0;
        int r = 1000000000;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(isPossible(mid, stones)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

    public boolean isPossible(int maxJump, int[] stones){

        Set<Integer> hs = new HashSet<Integer>();
        int last = 0;
        for(int i = 1; i < stones.length; i++){
            if(stones[i] - stones[last] > maxJump){
                if(i - last > 1){
                    hs.add(i - 1);
                    last = i - 1;
                    i--;
                }else{
                    return false;
                }
            }
        }

        last = stones.length - 1;

        for(int i = stones.length - 2; i >= 0; i--){
            if(!hs.contains(i)){
                if(stones[last] - stones[i] > maxJump){
                    return false;
                }else{
                    last = i;
                }
            }
        }

        return true;

    }
}