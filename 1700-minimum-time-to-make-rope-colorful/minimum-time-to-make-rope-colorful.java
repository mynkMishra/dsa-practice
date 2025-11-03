class Solution {

    public int minCost(String colors, int[] neededTime) {
        return solve(0, 1, colors, neededTime);
    }

    public int solve(int a, int b, String colors, int[] neededTime){
        if(a >= colors.length() || b >= colors.length()){
            return 0;
        }

        if(colors.charAt(a) == colors.charAt(b)){
            if(neededTime[b] <= neededTime[a]){
                return solve(a, b + 1, colors, neededTime) + neededTime[b];
            }else{
                return solve(b, b + 1, colors, neededTime) + neededTime[a];
            }
        }else{
            return solve(b, b + 1, colors, neededTime);
        }
    }
}