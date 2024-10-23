class TimeMap {

    Map<String, TreeMap<Integer, String>> hm;
    public TimeMap() {
        hm = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.get(key) == null){
            TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
            tm.put(timestamp, value);
            hm.put(key, tm);
        }else{
            hm.get(key).put(timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
        if(hm.get(key) == null){
            return "";
        }
        
        Map.Entry<Integer, String> e = hm.get(key).floorEntry(timestamp);

        if(e == null){
            return "";
        }

        return e.getValue();
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */