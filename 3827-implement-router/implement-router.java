class Router {

    class Packet{
        Integer source;
        Integer destination;
        Integer timestamp;

        public Packet(Integer source, Integer destination, Integer timestamp){
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;

            Packet packet = (Packet)o;

            return (source.equals(packet.source)) && 
            (destination.equals(packet.destination)) && 
            (timestamp.equals(packet.timestamp));
        }

        @Override
        public int hashCode(){
            return Objects.hash(source, destination, timestamp);
        }
    }

    Set<Packet> routerSet;
    LinkedList<Packet> routerQueue;
    int limit;
    Map<Integer, List<Integer>> counter;

    public Router(int memoryLimit) {
        limit = memoryLimit;
        routerSet = new HashSet<Packet>();
        routerQueue = new LinkedList<Packet>();
        counter = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {

        Packet packet = new Packet(source, destination, timestamp);
        if(routerSet.contains(packet)){
            return false;
        }
        
        if(routerQueue.size() == limit){
            forwardPacket();
        }

        routerSet.add(packet);
        routerQueue.addFirst(packet);

        if(counter.get(destination) == null){
            counter.put(destination, new ArrayList<Integer>());
        }
        
        int pos = getLowerBound(counter.get(destination), timestamp);
        counter.get(destination).add(pos, timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        
        if(routerQueue.size() == 0){
            return new int[0];
        }

        Packet oldPacket = routerQueue.removeLast();
        routerSet.remove(oldPacket);

        List<Integer> times = counter.get(oldPacket.destination);
        int idx = getLowerBound(times, oldPacket.timestamp);
        if(idx >= 0){
            times.remove(idx);
        }
        
        return new int[]{oldPacket.source, oldPacket.destination, oldPacket.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(counter.get(destination) == null){
            return 0;
        }
        
        List<Integer> times = counter.get(destination);
        int start = getLowerBound(times, startTime);
        int end = getUpperBound(times, endTime);
        
        // System.out.println(counter.get(destination) + " " + start + " " + end);
        // start = start < 0 ? -start - 1 : start;
        // end = end < 0 ? -end - 1 : end + 1;

        return end - start;
    }

    public int getLowerBound(List<Integer> list, int val){
        int l = 0;
        int r = list.size() - 1;

        while(l <= r){
            int m = (l + r)/2;

            if(list.get(m) >= val){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }

        return l;
    }

    public int getUpperBound(List<Integer> list, int val){
        int l = 0;
        int r = list.size() - 1;

        while(l <= r){
            int m = (l + r)/2;

            if(list.get(m) > val){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }

        return l;
    }

 
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */