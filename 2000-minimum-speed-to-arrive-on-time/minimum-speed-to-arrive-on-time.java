class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int l = 0;
        int total = 0;

        for(int el: dist){
            total += el;
        }

        double h = (double)total/(double)hour;

        l = (int)Math.floor(h);

        int r = Integer.MIN_VALUE;

        for(int d: dist){
            r = Math.max(d, r);
        }

        r = r*100;

        while(l <= r){
            int mid = l + (r - l)/2;
            if((mid != 0 && !isValidSpeed(mid - 1, dist, hour)) && isValidSpeed(mid, dist, hour)){
                return mid;
            }

            if(isValidSpeed(mid, dist, hour)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return -1;
    }

    public boolean isValidSpeed(int minSpeed, int[] dist, double hour){

        double totalHour = 0;

        for(int i = 0; i < dist.length - 1; i++){

            int d = dist[i];
            int t = (int)Math.ceil(((double)d/(double)minSpeed));

            totalHour += (double)t;
        }

        double d = (double)dist[dist.length - 1]/(double)minSpeed;
        totalHour += d;

        return totalHour <= hour;
    }
}