class Logger {

    Map<String, Integer> hm;
    public Logger() {
        hm = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hm.get(message) == null){
            hm.put(message, timestamp);
            return true;
        }

        if(timestamp - hm.get(message) >= 10){
            hm.put(message, timestamp);
            return true;
        }

        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */