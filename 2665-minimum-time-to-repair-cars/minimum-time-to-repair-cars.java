class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        long l = 1;
        long r = 1000000000000000L;

        while(l <= r){
            long mid = l + (r - l)/2;
            if(check(mid, ranks, cars)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(long time, int[] ranks, int cars){  
        int total = 0;
        long count = 1;
        for(int r:ranks){
            while((long)((long)r*count*count) <= time && total < cars){
                total++;
                count++;
            }

            if(total == cars){
                break;
            }

            count = 1;
        }

        if(total >= cars){
            return true;
        }
        return false;
    }
}