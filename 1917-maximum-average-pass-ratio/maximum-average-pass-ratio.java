class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(
            (a, b) -> Double.compare(b[0],a[0]));

        for(int[] p: classes){
            // [gain, passCount, totalCount]
            pq.add(new double[]{calculateGain(p[0], p[1]), p[0],p[1]});
        }

        while(extraStudents > 0){
            double[] current = pq.poll();

            double currGain = current[0];
            int passCount = (int) current[1];
            int totalCount = (int) current[2];

            pq.add(new double[]{calculateGain(passCount + 1, totalCount + 1), passCount + 1, totalCount + 1 });
            extraStudents--;
        }

        double ans = 0;

        while(pq.size() > 0){
            double[] curr = pq.poll();
            int pass = (int) curr[1];
            int total = (int) curr[2];

            double d = (double)pass/total;
            ans += d;
        }

        double res = (double)(ans/classes.length);
        return res;
    }

    public double calculateGain(int passCount, int totalCount){
        return (
            (double)(passCount + 1)/(totalCount + 1) -
            (double)passCount/totalCount
        );
    }
}