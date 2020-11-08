class Logger {
    Map<String, Integer> olderMap;
    Map<String, Integer> newerMap;
    int ts;
    
    /** Initialize your data structure here. */
    public Logger() {
        olderMap = new HashMap<>();
        newerMap = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp >= ts + 20) {
            olderMap.clear();
            newerMap.clear();
            ts = timestamp;
        } else if (timestamp >= ts + 10) {
            olderMap = new HashMap<>(newerMap);
            newerMap = new HashMap<>();
            ts = timestamp;
        }
        
        if (newerMap.containsKey(message)) {
            return false;
        }
        
        if (olderMap.containsKey(message)) {
            if (olderMap.get(message) + 10 > timestamp) {
                return false;
            }
        }
        
        newerMap.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */