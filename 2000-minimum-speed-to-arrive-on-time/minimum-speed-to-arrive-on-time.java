class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int l = 1;
        int r = 10000000;
        int minSpeed = -1;

        while(l<=r){
            int mid = l + (r - l)/2;

            if(findSpeed(dist, mid, hour)){
                minSpeed = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return minSpeed;
    }

    public boolean findSpeed(int[] dist, int speed, double hour){

        double time = 0;

        for(int i = 0; i < dist.length; i++){
            double r = ((double)dist[i]/(double)speed);
            
            if(i != dist.length - 1){
                time += Math.ceil(r);
            }else{
                time += r;
            }
        }

        if(time > hour){
            return false;
        }

        return true;
    }
}