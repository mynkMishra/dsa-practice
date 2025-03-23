class StockPrice {

    int latestTimestamp = -1;
    int maxPrice = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;
    Map<Integer, Integer> hm;
    TreeMap<Integer, Set<Integer>> tm;
    public StockPrice() {
        hm = new HashMap<>();
        tm = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(timestamp > latestTimestamp){
            latestTimestamp = timestamp;
        }

        if(maxPrice < price){
            maxPrice = price;
        }

        if(minPrice > price){
            minPrice = price;
        }

        if(hm.containsKey(timestamp)){
            tm.get(hm.get(timestamp)).remove(timestamp);

            if(tm.get(hm.get(timestamp)).size() == 0){
                tm.remove(hm.get(timestamp));
            }
        }

        if(!tm.containsKey(price)){
            tm.put(price, new HashSet<>());
        }
        tm.get(price).add(timestamp);
        hm.put(timestamp, price);
    }
    
    public int current() {
        return hm.get(latestTimestamp);
    }
    
    public int maximum() {
        return tm.lastKey();
    }
    
    public int minimum() {
        return tm.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */