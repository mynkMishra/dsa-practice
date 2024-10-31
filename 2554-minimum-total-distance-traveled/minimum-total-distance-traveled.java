class Solution {

    long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        dp = new long[101][100000];
        for(long[] d: dp){
            Arrays.fill(d, -1);
        }

        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        List<Integer> fac = new ArrayList<Integer>();
        for(int[] f: factory){
            for(int i = 0; i < f[1]; i++){
                fac.add(f[0]);
            }
        }

        return solve(0, 0, 
                robot.stream().mapToInt(i -> i).toArray(), 
                fac.stream().mapToInt(i -> i).toArray());
    }

    public long solve(int rIdx, int fIdx, int[] robot, int[] factoryPos){

        if(rIdx == robot.length){
            return 0;
        }

        if(fIdx == factoryPos.length){
            return (long)1e12;
        }

        if(dp[rIdx][fIdx] != -1){
            return dp[rIdx][fIdx];
        }

        long assign = Math.abs(robot[rIdx] - factoryPos[fIdx]) + 
                        solve(rIdx + 1, fIdx + 1, robot, factoryPos);
        
        long skip = solve(rIdx, fIdx + 1, robot, factoryPos);

        return dp[rIdx][fIdx] = Math.min(assign, skip);
    }
}